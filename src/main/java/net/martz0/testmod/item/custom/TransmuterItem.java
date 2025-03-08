package net.martz0.testmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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

        if (blockState.isSolidBlock(world, blockPos) && blockState.isFullCube(world, blockPos) && !blockState.hasBlockEntity()) {
            if (!world.isClient()) {
                world.playSound(null, blockPos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
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
}