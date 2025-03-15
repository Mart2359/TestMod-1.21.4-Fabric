package net.martz0.testmod.block.custom;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends MiningToolItem {

    public HammerItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, BlockTags.PICKAXE_MINEABLE, attackDamage, attackSpeed, settings);
    }

    public static List<BlockPos> getBlocksToDestroy(int range, BlockPos blockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(player.getBlockInteractionRange(), 0, false);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;

            if (blockHit.getSide() == Direction.UP || blockHit.getSide() == Direction.DOWN) {
                for (int x = -range; x <= range; x++) {
                    for (int y = -range; y <= range; y++)
                        positions.add(new BlockPos(blockPos.getX() + x, blockPos.getY(), blockPos.getZ() + y));
                }
            }
            if (blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH) {
                for (int x = -range; x <= range; x++) {
                    for (int y = -range; y <= range; y++)
                        positions.add(new BlockPos(blockPos.getX() + x, blockPos.getY() + y, blockPos.getZ()));
                }
            }
            if (blockHit.getSide() == Direction.WEST || blockHit.getSide() == Direction.EAST) {
                for (int x = -range; x <= range; x++) {
                    for (int y = -range; y <= range; y++)
                        positions.add(new BlockPos(blockPos.getX(), blockPos.getY() + y, blockPos.getZ() + x));
                }
            }
        }

        return positions;
    }
}
