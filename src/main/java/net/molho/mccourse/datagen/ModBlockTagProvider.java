package net.molho.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.molho.mccourse.blocks.ModBlocks;
import net.molho.mccourse.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PINK_GARNET_ORE,
                        ModBlocks.PINK_GARNET_BLOCK,
                        ModBlocks.RAW_PINK_GARNET_BLOCK,
                        ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                        ModBlocks.END_PINK_GARNET_ORE,
                        ModBlocks.NETHER_PINK_GARNET_ORE,
                        ModBlocks.PINK_GARNET_SLAB,
                        ModBlocks.PINK_GARNET_STAIRS,
                        ModBlocks.PINK_GARNET_FENCE,
                        ModBlocks.PINK_GARNET_FENCE_GATE,
                        ModBlocks.PINK_GARNET_WALL,
                        ModBlocks.PINK_GARNET_DOOR,
                        ModBlocks.PINK_GARNET_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_PINK_GARNET_ORE,
                        ModBlocks.END_PINK_GARNET_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PINK_GARNET_BLOCK,
                        ModBlocks.RAW_PINK_GARNET_BLOCK,
                        ModBlocks.PINK_GARNET_ORE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.PINK_GARNET_WALL);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.PINK_GARNET_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.PINK_GARNET_FENCE_GATE);


        /** Needs Netherite ++**/
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);

        /** Needs Pink Garnet ++**/
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_5")))
                .add(ModBlocks.END_PINK_GARNET_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.PAXEL_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE)
                .forceAddTag(BlockTags.SHOVEL_MINEABLE);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.DRIFTWOOD_LOG, ModBlocks.STRIPPED_DRIFTWOOD_LOG, ModBlocks.DRIFTWOOD_WOOD, ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
    }


}
