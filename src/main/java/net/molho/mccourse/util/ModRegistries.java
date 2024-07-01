package net.molho.mccourse.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.ComposterBlock;
import net.molho.mccourse.item.ModItens;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
    }

    public static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItens.PEAT_BRICK, 200);
    }

    public static void registerModCompostable(){
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItens.CAULIFLOWER, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItens.CAULIFLOWER_SEEDS, 0.25f);
    }
}
