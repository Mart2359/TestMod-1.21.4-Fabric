package net.martz0.testmod.util;

import net.martz0.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> NEEDS_RAMA_CRYSTAL_TOOL = createTag("needs_rama_crystal_tool");
        public static final TagKey<Block> INCORRECT_FOR_RAMA_CRYSTAL_TOOL = createTag("incorrect_for_rama_crystal_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TestMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> WEIRD_BLOCK_TRANSFORMABLE = createTag("weird_block_transformable");
        public static final TagKey<Item> RAMA_CRYSTAL_TOOL_MATERIALS = createTag("rama_crystal_tool_materials");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, name));
        }
    }
}
