package net.martz0.testmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.martz0.testmod.block.ModBlocks;
import net.martz0.testmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAMA_CRYSTAL_BLOCK);
        registerSmithingTable(ModBlocks.INFUSION_TABLE, blockStateModelGenerator);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WEIRD_BLOCK);
    }

    private void registerSmithingTable(Block block, BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textureMap = new TextureMap()
                .put(TextureKey.PARTICLE, TextureMap.getSubId(block, "_front"))
                .put(TextureKey.DOWN, TextureMap.getSubId(block, "_bottom"))
                .put(TextureKey.UP, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.NORTH, TextureMap.getSubId(block, "_front"))
                .put(TextureKey.SOUTH, TextureMap.getSubId(block, "_front"))
                .put(TextureKey.EAST, TextureMap.getSubId(block, "_side"))
                .put(TextureKey.WEST, TextureMap.getSubId(block, "_side"));
        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSingletonBlockState(block, Models.CUBE.upload(block, textureMap, blockStateModelGenerator.modelCollector))
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DARK_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAMA_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAMA_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_TRANSMUTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BANANA, Models.GENERATED);
    }
}
