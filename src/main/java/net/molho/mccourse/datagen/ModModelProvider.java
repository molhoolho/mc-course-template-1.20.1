package net.molho.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.molho.mccourse.blocks.ModBlocks;
import net.molho.mccourse.item.ModItens;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool pinkGarnetTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_PINK_GARNET_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);

        pinkGarnetTexturePool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetTexturePool.slab(ModBlocks.PINK_GARNET_SLAB);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItens.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItens.RAW_PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItens.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItens.PEAT_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItens.METAL_DETECTOR, Models.GENERATED);
    }
}
