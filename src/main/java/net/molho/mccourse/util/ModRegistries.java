package net.molho.mccourse.util;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.molho.mccourse.blocks.ModBlocks;
import net.molho.mccourse.command.ReturnHomeCommand;
import net.molho.mccourse.command.SetHomeCommand;
import net.molho.mccourse.entity.ModEntities;
import net.molho.mccourse.entity.custom.PorcupineEntity;
import net.molho.mccourse.events.AttackEntityHandler;
import net.molho.mccourse.events.PlayerCopyHandler;
import net.molho.mccourse.item.ModItens;
import net.molho.mccourse.mixin.BrewingRecipeRegistryMixin;
import net.molho.mccourse.potion.ModPotion;
import net.molho.mccourse.villager.ModVillagers;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerModCompostable();
        registerCommands();
        registerEvents();
        registerPotionRecipes();
        registerCustomTrades();
        registerStrippables();
        registerFlammables();
        registerAttributes();

    }

    private static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItens.PEAT_BRICK, 200);
    }

    private static void registerModCompostable(){
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItens.CAULIFLOWER, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItens.CAULIFLOWER_SEEDS, 0.25f);
    }

    private static void registerCommands(){
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }

    private static void registerStrippables(){
        StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_LOG, ModBlocks.DRIFTWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_WOOD, ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
    }

    private static void registerFlammables(){
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_SAPLING, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_PLANKS, 5, 20);
    }

    private static void registerEvents(){
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
        ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());
    }

    private static void registerPotionRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItens.PINK_GARNET, ModPotion.SLIMEY_POTION);
    }

    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItens.CAULIFLOWER, 2), 6, 2, 0.02f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(ModItens.PINK_GARNET_PAXEL, 1), 2, 6, 0.08f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(ModItens.RADIATION_STAFF, 1), 6, 19, 0.08f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(ModItens.METAL_DETECTOR, 1), 1, 5, 0.08f
                    ));
                });
    }
}
