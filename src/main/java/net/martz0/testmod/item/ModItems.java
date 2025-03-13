package net.martz0.testmod.item;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.martz0.testmod.TestMod;
import net.martz0.testmod.component.ModDataComponentTypes;
import net.martz0.testmod.item.custom.TransmuterItem;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Function;

public final class ModItems {

    public static final Item DARK_FEATHER = register("dark_feather", Item::new, new Item.Settings());
    public static final Item RAMA_ESSENCE = register("rama_essence", Item::new, new Item.Settings());
    public static final Item RAMA_CRYSTAL = register("rama_crystal", Item::new, new Item.Settings());

    public static final Item DIAMOND_TRANSMUTER = register("diamond_transmuter", settings -> new TransmuterItem(Blocks.DIAMOND_BLOCK, settings) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown())
                tooltip.add(Text.translatable("tooltip.testmod.diamond_transmuter"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    }, new Item.Settings().maxDamage(64).component(ModDataComponentTypes.TIMES_USED, 0));
    public static final Item BANANA = register("banana", Item::new, new Item.Settings().food(ModFoodComponents.BANANA, ModConsumableComponents.BANANA));

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items For " + TestMod.MOD_ID);

        FuelRegistryEvents.BUILD.register((builder, context) -> builder.add(ModItems.DIAMOND_TRANSMUTER, 1600));
    }
}