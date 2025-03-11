package net.martz0.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.martz0.testmod.block.ModBlocks;
import net.martz0.testmod.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.MISC, ModItems.RAMA_CRYSTAL)
                        .pattern(" r ")
                        .pattern("rar")
                        .pattern(" r ")
                        .input('r', ModItems.RAMA_ESSENCE)
                        .input('a', Items.AMETHYST_SHARD)
                        .group("multi_bench")
                        .criterion(hasItem(ModItems.RAMA_ESSENCE), conditionsFromItem(ModItems.RAMA_ESSENCE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAMA_CRYSTAL_BLOCK)
                        .pattern("rrr")
                        .pattern("rrr")
                        .pattern("rrr")
                        .input('r', ModItems.RAMA_CRYSTAL)
                        .group("multi_bench")
                        .criterion(hasItem(ModItems.RAMA_CRYSTAL), conditionsFromItem(ModItems.RAMA_CRYSTAL))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ModItems.RAMA_CRYSTAL)
                        .input(ModBlocks.RAMA_CRYSTAL_BLOCK)
                        .criterion(hasItem(ModBlocks.RAMA_CRYSTAL_BLOCK), conditionsFromItem(ModBlocks.RAMA_CRYSTAL_BLOCK))
                        .offerTo(exporter, "rama_crystal_from_rama_crystal_block");
                createShaped(RecipeCategory.MISC, ModBlocks.INFUSION_TABLE)
                        .pattern("rr")
                        .pattern("pp")
                        .pattern("pp")
                        .input('r', ModItems.RAMA_CRYSTAL)
                        .input('p', ItemTags.PLANKS)
                        .group("multi_bench")
                        .criterion(hasItem(ModItems.RAMA_CRYSTAL), conditionsFromItem(ModItems.RAMA_CRYSTAL))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, ModItems.DIAMOND_TRANSMUTER)
                        .pattern("d")
                        .pattern("s")
                        .input('d', Items.DIAMOND_BLOCK)
                        .input('s', Items.STICK)
                        .group("multi_bench")
                        .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, ModBlocks.WEIRD_BLOCK)
                        .pattern("aga")
                        .pattern("gcg")
                        .pattern("aga")
                        .input('a', Items.AMETHYST_BLOCK)
                        .input('g', Items.GLASS)
                        .input('c', Items.CRAFTING_TABLE)
                        .group("multi_bench")
                        .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
