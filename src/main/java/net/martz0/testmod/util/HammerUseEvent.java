package net.martz0.testmod.util;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.martz0.testmod.block.custom.HammerItem;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class HammerUseEvent implements PlayerBlockBreakEvents.Before{

    private static final Set<BlockPos> BROKEN_BLOCKS = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity playerEntity, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity) {
        ItemStack mainHandItem = playerEntity.getMainHandStack();

        if (mainHandItem.getItem() instanceof HammerItem hammer && playerEntity instanceof ServerPlayerEntity player) {
            if (BROKEN_BLOCKS.contains(blockPos))
                return true;

            for (BlockPos pos : HammerItem.getBlocksToDestroy(1, blockPos, player)) {
                if (blockPos == pos || !hammer.isCorrectForDrops(mainHandItem, world.getBlockState(pos)))
                    continue;
                BROKEN_BLOCKS.add(pos);
                player.interactionManager.tryBreakBlock(pos);
                BROKEN_BLOCKS.remove(pos);
            }
        }

        return true;
    }
}
