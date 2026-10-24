package com.neonchrome.effect;

import com.neonchrome.NeonChrome;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

/** The price of overclocking: your nervous system needs a moment to cool down. */
public class BurnoutEffect extends MobEffect {
	public BurnoutEffect() {
		super(MobEffectCategory.HARMFUL, 0xFF2E97);

		this.addAttributeModifier(
				Attributes.MOVEMENT_SPEED,
				Identifier.fromNamespaceAndPath(NeonChrome.MOD_ID, "effect.burnout_speed"),
				-0.3,
				AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
		);
		this.addAttributeModifier(
				Attributes.ATTACK_SPEED,
				Identifier.fromNamespaceAndPath(NeonChrome.MOD_ID, "effect.burnout_attack_speed"),
				-0.25,
				AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
		);
	}
}
