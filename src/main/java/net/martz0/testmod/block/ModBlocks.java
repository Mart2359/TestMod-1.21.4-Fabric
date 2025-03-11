package net.martz0.testmod.block;

import net.martz0.testmod.TestMod;
import net.martz0.testmod.block.custom.WeirdBlock;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block RAMA_CRYSTAL_BLOCK = register(
            "rama_crystal_block",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLACK)
                    .requiresTool()
                    .strength(4F, 6F)
                    .sounds(BlockSoundGroup.METAL),
            true
    );

    public static final Block INFUSION_TABLE = register(
            "infusion_table",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable(),
            true
    );

    public static final Block WEIRD_BLOCK = register(
            "weird_block",
            WeirdBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.MAGENTA)
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(4F)
                    .sounds(BlockSoundGroup.GLASS),
            true
    );

    public static final Block SMOOTH_STONE_STAIRS = register(
            "smooth_stone_stairs",
            settings -> new StairsBlock(Blocks.SMOOTH_STONE.getDefaultState(), settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(BlockSoundGroup.STONE),
            true
    );

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(TestMod.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, name));
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering Mod Blocks For " + TestMod.MOD_ID);
    }
}