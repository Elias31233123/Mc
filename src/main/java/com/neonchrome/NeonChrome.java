package com.neonchrome;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neonchrome.block.ModBlocks;
import com.neonchrome.effect.ComedownHandler;
import com.neonchrome.effect.ModEffects;
import com.neonchrome.item.ModItems;

public class NeonChrome implements ModInitializer {
	public static final String MOD_ID = "neon_chrome";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Order matters: items reference effects, so effects are loaded first.
		ModEffects.initialize();
		ModItems.initialize();
		ModBlocks.initialize();
		ComedownHandler.initialize();

		LOGGER.info("Neon Chrome loaded. Stay chrome, choom.");
	}
}
