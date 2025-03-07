package net.martz0.testmod.item;

import net.martz0.testmod.TestMod;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public final class ModItems {

    public static final Item DARK_FEATHER = register("dark_feather", Item::new, new Item.Settings());
    public static final Item RAMA_ESSENCE = register("rama_essence", Item::new, new Item.Settings());
    public static final Item RAMA_CRYSTAL = register("rama_crystal", Item::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items For " + TestMod.MOD_ID);
    }
}
