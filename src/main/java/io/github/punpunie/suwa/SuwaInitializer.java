package io.github.punpunie.suwa;

import net.ornithemc.osl.entrypoints.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SuwaInitializer implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("Suwa");

	@Override
	public void init() {
		LOGGER.info("initializing suwa !");
	}
}
