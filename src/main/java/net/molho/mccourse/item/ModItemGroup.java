package net.molho.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
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
                        entries.add(ModItens.CAULIFLOWER_SEEDS);


                        entries.add(ModItens.PEAT_BRICK);
                        entries.add(ModItens.BAR_BRAWL_MUSIC_DISC);
                        entries.add(ModItens.RADIATION_STAFF);
                        entries.add(ModItens.PINK_GARNET_BOW);
                        entries.add(ModItens.PINK_GARNET_SHIELD);

                        entries.add(ModItens.METAL_DETECTOR);
                        entries.add(ModItens.DATA_TABLET);

                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_STAIRS);
                        entries.add(ModBlocks.PINK_GARNET_BUTTON);
                        entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
                        entries.add(ModBlocks.PINK_GARNET_SLAB);
                        entries.add(ModBlocks.PINK_GARNET_FENCE);
                        entries.add(ModBlocks.PINK_GARNET_FENCE_GATE);
                        entries.add(ModBlocks.PINK_GARNET_WALL);
                        entries.add(ModBlocks.PINK_GARNET_DOOR);
                        entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);


                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
                        entries.add(ModBlocks.NETHER_PINK_GARNET_ORE);
                        entries.add(ModBlocks.END_PINK_GARNET_ORE);
                        entries.add(ModBlocks.SOUND_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_LAMP_BLOCK);
                        entries.add(ModBlocks.GEM_EMPOWERING_STATION);

                        entries.add(ModBlocks.PETUNIA);

                        entries.add(ModBlocks.DRIFTWOOD_SAPLING);
                        entries.add(ModBlocks.DRIFTWOOD_LEAVES);
                        entries.add(ModBlocks.DRIFTWOOD_LOG);
                        entries.add(ModBlocks.DRIFTWOOD_PLANKS);
                        entries.add(ModBlocks.DRIFTWOOD_WOOD);
                        entries.add(ModBlocks.STRIPPED_DRIFTWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

                        entries.add(ModItens.PORCUPINE_SPAWN_EGG);


                        entries.add(ModItens.PINK_GARNET_HELMET);
                        entries.add(ModItens.PINK_GARNET_CHESTPLATE);
                        entries.add(ModItens.PINK_GARNET_LEGGINGS);
                        entries.add(ModItens.PINK_GARNET_BOOTS);


                        entries.add(ModItens.PINK_GARNET_HORSE_ARMOR);

                        entries.add(ModItens.PINK_GARNET_SWORD);
                        entries.add(ModItens.PINK_GARNET_PICKAXE);
                        entries.add(ModItens.PINK_GARNET_SHOVEL);
                        entries.add(ModItens.PINK_GARNET_AXE);
                        entries.add(ModItens.PINK_GARNET_HOE);
                        entries.add(ModItens.PINK_GARNET_PAXEL);
                    }).build());

    public static void registerItemGroups(){

    }
}
