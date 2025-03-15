package net.martz0.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.martz0.testmod.TestMod;
import net.martz0.testmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> TEST_MOD_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(TestMod.MOD_ID, "test_mod"));
    public static final ItemGroup TEST_MOD_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.RAMA_ESSENCE))
            .displayName(Text.translatable("itemGroup.testmod.testmod"))
            .build();

    public static void registerTestModItemGroup() {
        Registry.register(Registries.ITEM_GROUP, TEST_MOD_ITEM_GROUP_KEY, TEST_MOD_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(TEST_MOD_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.RAMA_ESSENCE);
            itemGroup.add(ModItems.DARK_FEATHER);
            itemGroup.add(ModItems.RAMA_CRYSTAL);
            itemGroup.add(ModBlocks.RAMA_CRYSTAL_BLOCK);
            itemGroup.add(ModBlocks.INFUSION_TABLE);
            itemGroup.add(ModItems.DIAMOND_TRANSMUTER);
            itemGroup.add(ModBlocks.WEIRD_BLOCK);
            itemGroup.add(ModItems.BANANA);
            itemGroup.add(ModBlocks.SMOOTH_STONE_STAIRS);
            itemGroup.add(ModItems.RAMA_CRYSTAL_SWORD);
            itemGroup.add(ModItems.RAMA_CRYSTAL_PICKAXE);
            itemGroup.add(ModItems.RAMA_CRYSTAL_AXE);
            itemGroup.add(ModItems.RAMA_CRYSTAL_SHOVEL);
            itemGroup.add(ModItems.RAMA_CRYSTAL_HOE);
            itemGroup.add(ModItems.RAMA_CRYSTAL_HAMMER);
        });
    }

    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups For " + TestMod.MOD_ID);

        registerTestModItemGroup();
    }
}
