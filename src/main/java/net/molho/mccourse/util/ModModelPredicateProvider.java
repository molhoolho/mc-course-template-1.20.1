package net.molho.mccourse.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.molho.mccourse.MCCourse;
import net.molho.mccourse.item.ModItens;

public class ModModelPredicateProvider {
    public static void registerModModels(){
        ModelPredicateProviderRegistry.register(ModItens.DATA_TABLET, new Identifier(MCCourse.MOD_ID, "on"),
                (stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0);
    }
}
