package net.martz0.testmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WeirdBlock extends Block {

    public WeirdBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(null, pos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity item) {
            if (item.getStack().getItem() == Items.IRON_INGOT) {
                item.setStack(new ItemStack(Items.IRON_NUGGET, item.getStack().getCount()*9));
            } else if (item.getStack().getItem() == Items.GOLD_INGOT) {
                item.setStack(new ItemStack(Items.GOLD_NUGGET, item.getStack().getCount()*9));
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
