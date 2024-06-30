package net.molho.mccourse.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.molho.mccourse.item.ModItens;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
    }

    public static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItens.PEAT_BRICK, 200);
    }
}
