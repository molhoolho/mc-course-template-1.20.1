package net.molho.mccourse.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.molho.mccourse.MCCourse;
import net.molho.mccourse.effects.ModEffects;

public class ModPotion {

    public static Potion SLIMEY_POTION = registerPotion("slimey_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 200, 0)));

    private static Potion registerPotion(String name, Potion potion){
        return Registry.register(Registries.POTION, new Identifier(MCCourse.MOD_ID, name), potion);
    }

    public static void registerPotion(){
        MCCourse.LOGGER.info("Registering Mod Potions for " + MCCourse.MOD_ID);
    }
}
