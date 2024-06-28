package net.molho.mccourse;

import net.fabricmc.api.ModInitializer;

import net.molho.mccourse.item.ModItens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourse implements ModInitializer {
	public static final String MOD_ID = "mccourse";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID	);

	@Override
	public void onInitialize() {
		//Use for make the itens up on the game
		ModItens.registerModItens();
	}
}