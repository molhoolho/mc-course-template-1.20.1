package net.molho.mccourse.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.molho.mccourse.MCCourse;

public class ModScreenHandlers {

    public static final ScreenHandlerType<GemEmpoweringScreenHandler> GEM_EMPOWERING_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(MCCourse.MOD_ID, "gem_empowering_screen_handler"),
            new ExtendedScreenHandlerType<>(GemEmpoweringScreenHandler::new));

    public static void registerScreenHandler(){
        MCCourse.LOGGER.info("Registering Screen Handlers for " + MCCourse.MOD_ID);
    }
}
