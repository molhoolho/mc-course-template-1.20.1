package net.molho.mccourse;

import net.fabricmc.api.ModInitializer;

import net.molho.mccourse.blocks.ModBlocks;
import net.molho.mccourse.effects.ModEffects;
import net.molho.mccourse.enchantment.ModEnchantments;
import net.molho.mccourse.fluid.ModFluids;
import net.molho.mccourse.item.ModItemGroup;
import net.molho.mccourse.item.ModItens;
import net.molho.mccourse.paiting.ModPaintings;
import net.molho.mccourse.particle.ModParticles;
import net.molho.mccourse.potion.ModPotion;
import net.molho.mccourse.sound.ModSounds;
import net.molho.mccourse.util.ModLootTableModifiers;
import net.molho.mccourse.util.ModRegistries;
import net.molho.mccourse.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourse implements ModInitializer {
	public static final String MOD_ID = "mccourse";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID	);

	@Override
	public void onInitialize() {
		//Use for make the itens up on the game
		ModItemGroup.registerItemGroups();
		ModItens.registerModItens();
		ModBlocks.registerModBlocks();
		ModEnchantments.registerModEnchantments();

		ModRegistries.registerModStuffs();
		ModSounds.registerSounds();
		ModLootTableModifiers.modifyLootTables();
		ModPaintings.registerPaintings();
		ModEffects.registerEffects();
		ModPotion.registerPotion();
		ModParticles.registerParticles();
		ModVillagers.registerVillagers();
		ModFluids.registerFluids();
	}
}