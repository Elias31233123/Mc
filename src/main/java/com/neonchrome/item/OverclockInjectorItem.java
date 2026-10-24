package com.neonchrome.item;

import com.neonchrome.effect.ModEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/** Right-click to inject: 15 seconds of overclock, followed by 20 seconds of burnout. */
public class OverclockInjectorItem extends Item {
	public static final int OVERCLOCK_TICKS = 15 * 20;

	public OverclockInjectorItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		// Don't stack boosts, and don't let people chain injectors through the comedown.
		if (player.hasEffect(ModEffects.OVERCLOCK) || player.hasEffect(ModEffects.BURNOUT)) {
			if (!level.isClientSide()) {
				player.sendSystemMessage(Component.translatable("message.neon_chrome.not_ready"));
			}
			return InteractionResult.FAIL;
		}

		if (!level.isClientSide()) {
			ItemStack stack = player.getItemInHand(hand);

			player.addEffect(new MobEffectInstance(ModEffects.OVERCLOCK, OVERCLOCK_TICKS, 0));
			player.sendSystemMessage(Component.translatable("message.neon_chrome.overclock"));
			level.playSound(null, player.blockPosition(), SoundEvents.BEACON_ACTIVATE, SoundSource.PLAYERS, 1.0F, 1.8F);

			if (!player.hasInfiniteMaterials()) {
				stack.shrink(1);
			}
		}

		return InteractionResult.SUCCESS;
	}
}
