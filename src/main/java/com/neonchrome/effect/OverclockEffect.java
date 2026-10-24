package com.neonchrome.effect;

import com.neonchrome.NeonChrome;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

/**
 * Time-dilation style boost: much faster movement and attack speed.
 * The matching comedown is handled by {@link ComedownHandler}.
 */
public class OverclockEffect extends MobEffect {
	public OverclockEffect() {
		super(MobEffectCategory.BENEFICIAL, 0x00F0FF);

		this.addAttributeModifier(
				Attributes.MOVEMENT_SPEED,
				Identifier.fromNamespaceAndPath(NeonChrome.MOD_ID, "effect.overclock_speed"),
				0.6,
				AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
		);
		this.addAttributeModifier(
				Attributes.ATTACK_SPEED,
				Identifier.fromNamespaceAndPath(NeonChrome.MOD_ID, "effect.overclock_attack_speed"),
				0.5,
				AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
		);
	}
}
