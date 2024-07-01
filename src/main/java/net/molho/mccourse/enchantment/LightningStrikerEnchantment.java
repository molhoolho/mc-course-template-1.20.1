package net.molho.mccourse.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class LightningStrikerEnchantment extends Enchantment {
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.getWorld().isClient()){
            ServerWorld world = ((ServerWorld) user.getWorld());
            BlockPos position = target.getBlockPos();

            if(level == 1){
                EntityType.LIGHTNING_BOLT.spawn(world, position, SpawnReason.TRIGGERED);
            } else if (level == 2) {
                EntityType.LIGHTNING_BOLT.spawn(world, position, SpawnReason.TRIGGERED);
                EntityType.LIGHTNING_BOLT.spawn(world, position, SpawnReason.TRIGGERED);
            }
        }

        super.onTargetDamaged(user, target, level);
    }

    protected LightningStrikerEnchantment(Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
