package net.martz0.testmod.block.custom;

import net.martz0.testmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class WeirdBlock extends Block {

    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");

    public WeirdBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(CLICKED, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            if (state.get(CLICKED))
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_FALL, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            else
                world.playSound(null, pos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            world.setBlockState(pos, state.cycle(CLICKED));
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity item) {
            if (isValidTerm(item.getStack())) {
                double x = item.getX();
                double y = item.getY();
                double z = item.getZ();
                float yaw = item.getBodyYaw();
                float pitch = item.getPitch();
                int count = item.getStack().getCount();
                item.discard();
                for (int i = 0; i < count; i++) {
                    if (world.getRandom().nextInt(10) == 0) {
                        ItemEntity diamond = new ItemEntity(world, x, y, z, new ItemStack(Items.DIAMOND));
                        diamond.setAngles(yaw, pitch);
                        world.spawnEntity(diamond);
                    } else {
                        ItemEntity coal = new ItemEntity(world, x, y, z, new ItemStack(Items.COAL));
                        coal.setAngles(yaw, pitch);
                        world.spawnEntity(coal);
                    }
                }
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidTerm(ItemStack stack) {
        return stack.isIn(ModTags.Items.WEIRD_BLOCK_TRANSFORMABLE);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.testmod.weird_block"));
        super.appendTooltip(stack, context, tooltip, options);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }
}
