package net.molho.mccourse.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.molho.mccourse.MCCourse;
import net.molho.mccourse.entity.custom.PorcupineEntity;

public class ModEntities {

    public static final EntityType<PorcupineEntity> PORCUPINE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MCCourse.MOD_ID, "porcupine"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PorcupineEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.74f)).build());

    public static void registerModEntities(){
        MCCourse.LOGGER.info("Registering Mod Entities " + MCCourse.MOD_ID);
    }
}
