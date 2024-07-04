package net.molho.mccourse.blocks.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.molho.mccourse.MCCourse;
import net.molho.mccourse.blocks.ModBlocks;

public class ModBlockEntities {

    public static final BlockEntityType<GemEmpoweringStationBlockEntity> GEM_EMPOWERING_STATION_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MCCourse.MOD_ID, "gem_empowering_block"),
                    FabricBlockEntityTypeBuilder.create(GemEmpoweringStationBlockEntity::new,
                            ModBlocks.GEM_EMPOWERING_STATION).build(null));

    public static void registerBlockEntities(){
        MCCourse.LOGGER.info("Registering Block Entities for " + MCCourse.MOD_ID);
    }
}
