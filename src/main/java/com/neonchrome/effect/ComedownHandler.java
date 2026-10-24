package com.neonchrome.effect;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;

/**
 * Applies {@link ModEffects#BURNOUT} as soon as a player's {@link ModEffects#OVERCLOCK} runs out.
 * <p>
 * Effects can't safely add other effects from inside their own tick, so we watch for the
 * "had overclock last tick, doesn't have it now" transition once per server tick instead.
 */
public final class ComedownHandler {
	public static final int BURNOUT_TICKS = 20 * 20;

	private static final Set<UUID> OVERCLOCKED = new HashSet<>();

	private ComedownHandler() {
	}

	public static void initialize() {
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (ServerPlayer player : server.getPlayerList().getPlayers()) {
				UUID id = player.getUUID();

				if (player.hasEffect(ModEffects.OVERCLOCK)) {
					OVERCLOCKED.add(id);
				} else if (OVERCLOCKED.remove(id) && player.isAlive()) {
					player.addEffect(new MobEffectInstance(ModEffects.BURNOUT, BURNOUT_TICKS, 0));
					player.displayClientMessage(Component.translatable("message.neon_chrome.burnout"), true);
				}
			}
		});
	}
}
