package net.molho.mccourse.datagen;

import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PaintingVariantTags;
import net.minecraft.util.Identifier;
import net.molho.mccourse.MCCourse;

import java.util.concurrent.CompletableFuture;

public class ModPaintingsVariantsTagProvider extends TagProvider<PaintingVariant> {
    public ModPaintingsVariantsTagProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.PAINTING_VARIANT, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(PaintingVariantTags.PLACEABLE)
                .addOptional(new Identifier(MCCourse.MOD_ID, "saw_them"))
                .addOptional(new Identifier(MCCourse.MOD_ID, "shrimp"))
                .addOptional(new Identifier(MCCourse.MOD_ID, "world"));
    }
}
