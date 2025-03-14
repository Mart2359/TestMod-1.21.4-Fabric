package net.martz0.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.martz0.testmod.block.ModBlocks;
import net.martz0.testmod.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAMA_CRYSTAL_BLOCK)
                .add(ModBlocks.SMOOTH_STONE_STAIRS);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.INFUSION_TABLE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAMA_CRYSTAL_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_RAMA_CRYSTAL_TOOL)
                .addOptionalTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
