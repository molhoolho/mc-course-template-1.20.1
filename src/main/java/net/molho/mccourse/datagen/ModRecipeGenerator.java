package net.molho.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.molho.mccourse.blocks.ModBlocks;
import net.molho.mccourse.item.ModItens;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItens.METAL_DETECTOR)
                .pattern("  S")
                .pattern(" S ")
                .pattern("IPI")
                .input('S', Items.STICK)
                .input('I', Items.IRON_INGOT)
                .input('P', ModItens.PINK_GARNET)
                /** The line above this commentary is for unlock the recipe in the book when has a
                 * Pink Garnet in the inventary **/
                .criterion(hasItem(ModItens.PINK_GARNET), conditionsFromItem(ModItens.PINK_GARNET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItens.METAL_DETECTOR)));

        /** Recipes that results in the same as metal blocks creation on Minecraft **/
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItens.PINK_GARNET, RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK);

        /** In this case, we talk about Smelting and Blasting. The first field after exporter says about what will be smelted/blasted
         * The third field says about the result, before the experience, cooking time and group **/
        offerSmelting(exporter, List.of(ModItens.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                        ModBlocks.NETHER_PINK_GARNET_ORE, ModBlocks.END_PINK_GARNET_ORE), RecipeCategory.MISC, ModItens.PINK_GARNET,
                0.25f, 200, "pink_garnet");
        offerBlasting(exporter, List.of(ModItens.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                        ModBlocks.NETHER_PINK_GARNET_ORE, ModBlocks.END_PINK_GARNET_ORE), RecipeCategory.MISC, ModItens.PINK_GARNET,
                0.25f, 200, "pink_garnet");
    }
}
