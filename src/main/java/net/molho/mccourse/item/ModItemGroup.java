package net.molho.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.molho.mccourse.MCCourse;
import net.molho.mccourse.blocks.ModBlocks;

public class ModItemGroup {

    //This is the function for create a group
    public static final ItemGroup PINK_GARNET_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MCCourse.MOD_ID, "pink_garnet_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pink_garnet_group"))
                    .icon(() -> new ItemStack(ModItens.PINK_GARNET)).entries((displayContext, entries) -> {
                        //Here put the items that will compound the group
                        entries.add(ModItens.PINK_GARNET);
                        entries.add(ModItens.RAW_PINK_GARNET);

                        entries.add(ModItens.CAULIFLOWER);


                        entries.add(ModItens.PEAT_BRICK);

                        entries.add(ModItens.METAL_DETECTOR);

                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
                        entries.add(ModBlocks.NETHER_PINK_GARNET_ORE);
                        entries.add(ModBlocks.END_PINK_GARNET_ORE);
                        entries.add(ModBlocks.SOUND_BLOCK);
                    }).build());

    public static void registerItemGroups(){

    }
}
