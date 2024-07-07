package net.molho.mccourse.entity.layer;

import net.molho.mccourse.MCCourse;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE =
            new EntityModelLayer(new Identifier(MCCourse.MOD_ID, "porcupine"), "main");
}
