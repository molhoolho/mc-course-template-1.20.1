package net.molho.mccourse.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.molho.mccourse.MCCourse;
import net.molho.mccourse.blocks.ModBlocks;
import net.molho.mccourse.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    /** useOnBlock is used when right click in a block. **/
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        /** Here check if is client of not.
         * Some things only can be done in server side, because if it in client side
         * can be easily cheated. **/
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            /** In this for, it will check if exists some valuable block right in the
             * Y down 64 blocks that the has clicked **/
            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState blockState = context.getWorld().getBlockState(positionClicked.down(i));
                Block block = blockState.getBlock();

                if(isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.down(i), player, block);
                    foundBlock = true;

                    break;
                }
            }

            /** Send a message for the player if not found any valuable item**/
            if(!foundBlock) {
                player.sendMessage(Text.translatable("item.mccourse.metal_detector.no_valuables"));
            }
        }


        /**Consumes the item health**/
        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    /** In this part, show the text when hover the mouse over the item **/
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.mccourse.metal_detector.tooltip"));
        }else {
            tooltip.add(Text.translatable("tooltip.mccourse.tooltip.shift"));
        }
    }

    /** Show the coordinates of the blocks that call it **/
    private void outputValuableCoordinates(BlockPos position, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Valuable Found: " + block.getName().getString() + " at " +
                "(" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")"));
    }

    /** Defines what block is valuable**/
    private boolean isValuableBlock(BlockState blockState) {
        return blockState.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS);
    }
}
