package net.martz0.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.martz0.testmod.item.ModItems;
import net.martz0.testmod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.WEIRD_BLOCK_TRANSFORMABLE)
                .add(Items.IRON_INGOT)
                .add(Items.GOLD_INGOT);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.RAMA_CRYSTAL_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.RAMA_CRYSTAL_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.RAMA_CRYSTAL_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.RAMA_CRYSTAL_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.RAMA_CRYSTAL_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.RAMA_CRYSTAL_HELMET)
                .add(ModItems.RAMA_CRYSTAL_CHESTPLATE)
                .add(ModItems.RAMA_CRYSTAL_LEGGINGS)
                .add(ModItems.RAMA_CRYSTAL_BOOTS);
    }
}
