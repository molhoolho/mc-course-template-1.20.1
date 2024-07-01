package net.molho.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.molho.mccourse.blocks.ModBlocks;
import net.molho.mccourse.blocks.custom.CauliflowerCropBlock;
import net.molho.mccourse.blocks.custom.PinkGarnetLampBlock;
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
        pinkGarnetTexturePool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetTexturePool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

        pinkGarnetTexturePool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetTexturePool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetTexturePool.wall(ModBlocks.PINK_GARNET_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);

        registerCustomLamp(blockStateModelGenerator);

        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE,0, 1, 2, 3, 4, 5, 6);
    }

    private void registerCustomLamp(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GARNET_LAMP_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(ModBlocks.PINK_GARNET_LAMP_BLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.PINK_GARNET_LAMP_BLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED, identifier2, identifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItens.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItens.RAW_PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItens.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItens.PEAT_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItens.METAL_DETECTOR, Models.GENERATED);
        //itemModelGenerator.register(ModItens.DATA_TABLET, Models.GENERATED);


        itemModelGenerator.register(ModItens.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItens.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItens.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItens.PINK_GARNET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItens.PINK_GARNET_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItens.PINK_GARNET_PAXEL, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItens.PINK_GARNET_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItens.PINK_GARNET_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItens.PINK_GARNET_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItens.PINK_GARNET_BOOTS);


        itemModelGenerator.register(ModItens.PINK_GARNET_HORSE_ARMOR, Models.GENERATED);
    }


}
