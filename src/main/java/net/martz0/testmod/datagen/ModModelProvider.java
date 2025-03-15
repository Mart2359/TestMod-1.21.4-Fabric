package net.martz0.testmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.martz0.testmod.block.ModBlocks;
import net.martz0.testmod.block.custom.WeirdBlock;
import net.martz0.testmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAMA_CRYSTAL_BLOCK);
        registerSmithingTable(ModBlocks.INFUSION_TABLE, blockStateModelGenerator);

        Identifier weirdBlockOff = TexturedModel.CUBE_ALL.upload(ModBlocks.WEIRD_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier weirdBlockOn = blockStateModelGenerator.createSubModel(ModBlocks.WEIRD_BLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.WEIRD_BLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(WeirdBlock.CLICKED, weirdBlockOn, weirdBlockOff)));

        registerCustomStairs(ModBlocks.SMOOTH_STONE_STAIRS, blockStateModelGenerator);
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

    private void registerCustomStairs(Block block, BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textureMap = new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getSubId(block, ""))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.PARTICLE, TextureMap.getSubId(block, "_top"));
        Identifier innerModelId = Models.INNER_STAIRS.upload(
                block,
                textureMap,
                blockStateModelGenerator.modelCollector
        );
        Identifier regularModelId = Models.STAIRS.upload(
                block,
                textureMap,
                blockStateModelGenerator.modelCollector
        );
        Identifier outerModelId = Models.OUTER_STAIRS.upload(
                block,
                textureMap,
                blockStateModelGenerator.modelCollector
        );
        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createStairsBlockState(block, innerModelId, regularModelId, outerModelId)
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DARK_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAMA_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAMA_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_TRANSMUTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BANANA, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAMA_CRYSTAL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAMA_CRYSTAL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAMA_CRYSTAL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAMA_CRYSTAL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAMA_CRYSTAL_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAMA_CRYSTAL_HAMMER, Models.HANDHELD);
    }
}
