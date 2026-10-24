package com.neonchrome.block;

import java.util.function.Function;

import com.neonchrome.NeonChrome;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
	// Glowing neon blocks: full light level, glass-like, quick to break.
	public static final Block NEON_CYAN = register("neon_cyan", Block::new, neonProperties());
	public static final Block NEON_MAGENTA = register("neon_magenta", Block::new, neonProperties());
	public static final Block NEON_YELLOW = register("neon_yellow", Block::new, neonProperties());

	// Sturdy decorative metal. Needs an iron pickaxe or better to drop.
	public static final Block CHROME_PLATING = register(
			"chrome_plating",
			Block::new,
			BlockBehaviour.Properties.of()
					.strength(5.0F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(SoundType.METAL)
	);

	private static BlockBehaviour.Properties neonProperties() {
		return BlockBehaviour.Properties.of()
				.strength(0.8F)
				.sound(SoundType.GLASS)
				.lightLevel(state -> 15);
	}

	private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
		ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(NeonChrome.MOD_ID, name));
		Block block = blockFactory.apply(properties.setId(blockKey));

		// Every block here gets a matching block item.
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NeonChrome.MOD_ID, name));
		BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
		Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

	public static void initialize() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(tab -> {
			tab.accept(CHROME_PLATING.asItem());
			tab.accept(NEON_CYAN.asItem());
			tab.accept(NEON_MAGENTA.asItem());
			tab.accept(NEON_YELLOW.asItem());
		});
	}
}
