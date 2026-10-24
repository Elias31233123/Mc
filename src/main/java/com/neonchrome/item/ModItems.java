package com.neonchrome.item;

import java.util.function.Function;

import com.neonchrome.NeonChrome;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ToolMaterial;

public class ModItems {
	/** Basic crafting component. Craft it from iron, redstone and glowstone dust. */
	public static final Item CHROME_SHARD = register("chrome_shard", Item::new, new Item.Properties());

	/** Right-click: overclock for 15 seconds, then burnout. Single use. */
	public static final Item OVERCLOCK_INJECTOR = register(
			"overclock_injector",
			OverclockInjectorItem::new,
			new Item.Properties().stacksTo(8).rarity(Rarity.UNCOMMON)
	);

	/** A diamond-tier sword, because every self-respecting chrome-head needs one. */
	public static final Item ARM_BLADE = register(
			"arm_blade",
			Item::new,
			new Item.Properties().sword(ToolMaterial.DIAMOND, 3.0F, -2.2F)
	);

	public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties properties) {
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NeonChrome.MOD_ID, name));
		T item = itemFactory.apply(properties.setId(itemKey));
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);
		return item;
	}

	public static void initialize() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
				.register(tab -> tab.accept(CHROME_SHARD));

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
				.register(tab -> tab.accept(OVERCLOCK_INJECTOR));

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
				.register(tab -> tab.accept(ARM_BLADE));
	}
}
