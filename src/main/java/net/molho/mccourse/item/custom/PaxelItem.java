package net.molho.mccourse.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.molho.mccourse.util.ModTags;

public class PaxelItem extends MiningToolItem {
    public PaxelItem( ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(attackDamage, attackSpeed, material, ModTags.Blocks.PAXEL_MINEABLE, settings);
    }
}
