package net.martz0.testmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class TransmuterItem extends Item {

    private final Block transmuter_block;

    public TransmuterItem(Block transmuter_block, Settings settings) {
        super(settings);
        this.transmuter_block = transmuter_block;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);

        if (blockState.isSolidBlock(world, blockPos) && blockState.isFullCube(world, blockPos) && !blockState.hasBlockEntity() && blockState.getBlock() != transmuter_block) {
            if (!world.isClient()) {
                world.playSound(null, blockPos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 0.5F, world.getRandom().nextFloat() * 0.25F + 0.6F);
                world.setBlockState(blockPos, transmuter_block.getDefaultState());

                if (playerEntity instanceof ServerPlayerEntity) {
                    context.getStack().damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                }
            }
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAIL;
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (!Screen.hasShiftDown())
            tooltip.add(Text.translatable("tooltip.testmod.details"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}