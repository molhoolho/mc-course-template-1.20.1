package net.molho.mccourse;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.model.ModelLoadingRegistryImpl;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.util.ModelIdentifier;
import net.molho.mccourse.blocks.ModBlocks;
import net.molho.mccourse.blocks.entity.ModBlockEntities;
import net.molho.mccourse.blocks.entity.renderer.GemEmpoweringBlockEntityRenderer;
import net.molho.mccourse.entity.ModEntities;
import net.molho.mccourse.entity.client.PorcupineModel;
import net.molho.mccourse.entity.client.PorcupineRenderer;
import net.molho.mccourse.entity.layer.ModModelLayers;
import net.molho.mccourse.fluid.ModFluids;
import net.molho.mccourse.networking.ModMessages;
import net.molho.mccourse.particle.ModParticles;
import net.molho.mccourse.particle.PinkGarnetParticle;
import net.molho.mccourse.screen.GemEmpoweringScreen;
import net.molho.mccourse.screen.ModScreenHandlers;
import net.molho.mccourse.util.ModModelPredicateProvider;

public class MCCourseModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PETUNIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POT_PETUNIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_SAPLING, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();

        ParticleFactoryRegistry.getInstance().register(ModParticles.PINK_GARNET_PARTICLE, PinkGarnetParticle.Factory::new);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER,
                SimpleFluidRenderHandler.coloredWater(0xA1E038D0));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER);

        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> new ModelIdentifier(MCCourse.MOD_ID, "radiation_staff_3d", "inventory"));

        HandledScreens.register(ModScreenHandlers.GEM_EMPOWERING_SCREEN_HANDLER, GemEmpoweringScreen::new);

        ModMessages.registerS2CPackets();

        BlockEntityRendererFactories.register(ModBlockEntities.GEM_EMPOWERING_STATION_BE, GemEmpoweringBlockEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRenderer::new);
    }
}
