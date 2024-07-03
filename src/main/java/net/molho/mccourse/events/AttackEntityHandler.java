package net.molho.mccourse.events;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stat;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.molho.mccourse.item.ModItemGroup;
import net.molho.mccourse.item.ModItens;
import org.jetbrains.annotations.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {

        if(entity instanceof VillagerEntity && !world.isClient() && !player.isSpectator()){
            if(player.getStackInHand(hand).getItem() == ModItens.PINK_GARNET_SWORD){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 876000000, 2));
                player.sendMessage(Text.literal(player.getName().getString() + " just hurted a sheep with our sword!"));
            }else{
                player.sendMessage(Text.literal(player.getName().getString() + " just hurted a sheep!"));
            }
        }

        return ActionResult.PASS;
    }


}
