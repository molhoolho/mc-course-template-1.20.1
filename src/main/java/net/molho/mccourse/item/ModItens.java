package net.molho.mccourse.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.molho.mccourse.MCCourse;
import net.molho.mccourse.blocks.ModBlocks;

public class ModItens {

    //This is for create basic items, but only with the facilitators
    public static final Item PINK_GARNET = registerItem("pink_garnet",
            new Item(new FabricItemSettings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item(new FabricItemSettings()));

    //One of facilitators
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MCCourse.MOD_ID, name), item);
    }

    //Entry the created item in Ingredients window
    private static void itemGroupIngredient(FabricItemGroupEntries entries){

    }

    //Other facilitator
    public static void registerModItens(){
        MCCourse.LOGGER.info("Registering Mod Items for " + MCCourse.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItens::itemGroupIngredient);
    }

}
