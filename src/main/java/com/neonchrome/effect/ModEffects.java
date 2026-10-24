package com.neonchrome.effect;

import com.neonchrome.NeonChrome;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;

public class ModEffects {
	public static final Holder<MobEffect> OVERCLOCK = register("overclock", new OverclockEffect());
	public static final Holder<MobEffect> BURNOUT = register("burnout", new BurnoutEffect());

	private static Holder<MobEffect> register(String name, MobEffect effect) {
		return Registry.registerForHolder(
				BuiltInRegistries.MOB_EFFECT,
				Identifier.fromNamespaceAndPath(NeonChrome.MOD_ID, name),
				effect
		);
	}

	/** Dummy method that forces the static fields above to be initialized. */
	public static void initialize() {
	}
}
