package net.molho.mccourse.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.molho.mccourse.MCCourse;
import net.molho.mccourse.blocks.ModBlocks;
import net.molho.mccourse.entity.ModEntities;
import net.molho.mccourse.item.custom.*;
import net.molho.mccourse.sound.ModSounds;

public class ModItens {

    //This is for create basic items, but only with the facilitators
    public static final Item PINK_GARNET = registerItem("pink_garnet",
            new Item(new FabricItemSettings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(256)));
    public static final Item DATA_TABLET = registerItem("data_tablet",
            new DataTabletItem(new FabricItemSettings().maxCount(1)));

    public static final Item CAULIFLOWER = registerItem("cauliflower",
            new Item(new FabricItemSettings().food(ModFoodComponents.CAULIFLOWER)));
    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",
            new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP, new FabricItemSettings()));

    public static final Item PEAT_BRICK = registerItem("peat_brick",
            new Item(new FabricItemSettings()));

    public static final Item BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc",
            new MusicDiscItem(9, ModSounds.BAR_BRAWL, new FabricItemSettings().maxCount(1), 122));

    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword",
            new ModPoisonSwordItem(ModToolMaterial.PINK_GARNET, 2, 2f, new FabricItemSettings()));
    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe",
            new PickaxeItem(ModToolMaterial.PINK_GARNET, 1, 1f, new FabricItemSettings()));
    public static final Item PINK_GARNET_SHOVEL = registerItem("pink_garnet_shovel",
            new ShovelItem(ModToolMaterial.PINK_GARNET, 0, 0f, new FabricItemSettings()));
    public static final Item PINK_GARNET_AXE = registerItem("pink_garnet_axe",
            new AxeItem(ModToolMaterial.PINK_GARNET, 6, 1.5f, new FabricItemSettings()));
    public static final Item PINK_GARNET_HOE = registerItem("pink_garnet_hoe",
            new HoeItem(ModToolMaterial.PINK_GARNET, 0, 0f, new FabricItemSettings()));

    public static final Item PINK_GARNET_PAXEL = registerItem("pink_garnet_paxel",
            new PaxelItem(ModToolMaterial.PINK_GARNET, 7, 2f, new FabricItemSettings()));

    public static final Item RADIATION_STAFF = registerItem("radiation_staff",
            new Item(new FabricItemSettings().maxCount(1)));

    public static final Item PINK_GARNET_BOW = registerItem("pink_garnet_bow",
            new BowItem(new FabricItemSettings().maxDamage(500)));

    public static final Item PINK_GARNET_SHIELD = registerItem("pink_garnet_shield",
            new ShieldItem(new FabricItemSettings().maxDamage(500)));

    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet",
            new ModArmorItem(ModArmorMaterial.PINK_GARNET, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate",
            new ModArmorItem(ModArmorMaterial.PINK_GARNET, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PINK_GARNET_LEGGINGS = registerItem("pink_garnet_leggings",
            new ModArmorItem(ModArmorMaterial.PINK_GARNET, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots",
            new ModArmorItem(ModArmorMaterial.PINK_GARNET, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item PINK_GARNET_HORSE_ARMOR = registerItem("pink_garnet_horse_armor",
            new HorseArmorItem(14, "pink_garnet", new FabricItemSettings()));

    public static final Item PORCUPINE_SPAWN_EGG = registerItem("porcupine_spawn_egg",
            new SpawnEggItem(ModEntities.PORCUPINE, 0xa86518, 0x3b260f, new FabricItemSettings()));

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
