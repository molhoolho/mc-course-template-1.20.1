package net.molho.mccourse.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.molho.mccourse.MCCourse;

public class ModParticles {
    public static final DefaultParticleType PINK_GARNET_PARTICLE =
            registerParticle("pink_garnet_particle", FabricParticleTypes.simple());


    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(MCCourse.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        MCCourse.LOGGER.info("Registering Mod Particles for " + MCCourse.MOD_ID);
    }
}
