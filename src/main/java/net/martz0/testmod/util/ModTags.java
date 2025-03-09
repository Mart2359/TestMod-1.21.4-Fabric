package net.martz0.testmod.util;

import net.martz0.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TestMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> WEIRD_BLOCK_TRANSFORMABLE = createTag("weird_block_transformable");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, name));
        }
    }
}
