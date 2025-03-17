package net.martz0.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.martz0.testmod.block.ModBlocks;
import net.martz0.testmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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
                        .criterion(hasItem(ModItems.RAMA_ESSENCE), conditionsFromItem(ModItems.RAMA_ESSENCE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAMA_CRYSTAL_BLOCK)
                        .pattern("rrr")
                        .pattern("rrr")
                        .pattern("rrr")
                        .input('r', ModItems.RAMA_CRYSTAL)
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
                        .criterion(hasItem(ModItems.RAMA_CRYSTAL), conditionsFromItem(ModItems.RAMA_CRYSTAL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.DIAMOND_TRANSMUTER)
                        .pattern("d")
                        .pattern("s")
                        .input('d', Items.DIAMOND_BLOCK)
                        .input('s', Items.STICK)
                        .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.WEIRD_BLOCK)
                        .pattern("aga")
                        .pattern("gcg")
                        .pattern("aga")
                        .input('a', Items.AMETHYST_BLOCK)
                        .input('g', Items.GLASS)
                        .input('c', Items.CRAFTING_TABLE)
                        .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                        .offerTo(exporter);

                createStairsRecipe(ModBlocks.SMOOTH_STONE_STAIRS, Ingredient.ofItem(Blocks.SMOOTH_STONE))
                        .criterion(hasItem(Blocks.SMOOTH_STONE), conditionsFromItem(Blocks.SMOOTH_STONE))
                        .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);

                createSword(ModItems.RAMA_CRYSTAL_SWORD, ModItems.RAMA_CRYSTAL);
                createPickaxe(ModItems.RAMA_CRYSTAL_PICKAXE, ModItems.RAMA_CRYSTAL);
                createAxe(ModItems.RAMA_CRYSTAL_AXE, ModItems.RAMA_CRYSTAL);
                createShovel(ModItems.RAMA_CRYSTAL_SHOVEL, ModItems.RAMA_CRYSTAL);
                createHoe(ModItems.RAMA_CRYSTAL_HOE, ModItems.RAMA_CRYSTAL);
                createHammer(ModItems.RAMA_CRYSTAL_HAMMER, ModItems.RAMA_CRYSTAL);

                createHelmet(ModItems.RAMA_CRYSTAL_HELMET, ModItems.RAMA_CRYSTAL);
                createChestplate(ModItems.RAMA_CRYSTAL_CHESTPLATE, ModItems.RAMA_CRYSTAL);
                createLeggings(ModItems.RAMA_CRYSTAL_LEGGINGS, ModItems.RAMA_CRYSTAL);
                createBoots(ModItems.RAMA_CRYSTAL_BOOTS, ModItems.RAMA_CRYSTAL);
            }

            private void createSword(ItemConvertible output, ItemConvertible material) {
                createShaped(RecipeCategory.COMBAT, output)
                        .pattern("m")
                        .pattern("m")
                        .pattern("s")
                        .input('m', material)
                        .input('s', Items.STICK)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(exporter);
            }
            private void createPickaxe(ItemConvertible output, ItemConvertible material) {
                createShaped(RecipeCategory.TOOLS, output)
                        .pattern("mmm")
                        .pattern(" s ")
                        .pattern(" s ")
                        .input('m', material)
                        .input('s', Items.STICK)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(exporter);
            }
            private void createAxe(ItemConvertible output, ItemConvertible material) {
                createShaped(RecipeCategory.TOOLS, output)
                        .pattern("mm")
                        .pattern("ms")
                        .pattern(" s")
                        .input('m', material)
                        .input('s', Items.STICK)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(exporter);
            }
            private void createShovel(ItemConvertible output, ItemConvertible material) {
                createShaped(RecipeCategory.TOOLS, output)
                        .pattern("m")
                        .pattern("s")
                        .pattern("s")
                        .input('m', material)
                        .input('s', Items.STICK)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(exporter);
            }
            private void createHoe(ItemConvertible output, ItemConvertible material) {
                createShaped(RecipeCategory.TOOLS, output)
                        .pattern("mm")
                        .pattern(" s")
                        .pattern(" s")
                        .input('m', material)
                        .input('s', Items.STICK)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(exporter);
            }
            private void createHammer(ItemConvertible output, ItemConvertible material) {
                createShaped(RecipeCategory.TOOLS, output)
                        .pattern("mmm")
                        .pattern("msm")
                        .pattern(" s ")
                        .input('m', material)
                        .input('s', Items.STICK)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(exporter);
            }
            private void createHelmet(ItemConvertible output, ItemConvertible material) {
                createShaped(RecipeCategory.COMBAT, output)
                        .pattern("mmm")
                        .pattern("m m")
                        .input('m', material)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(exporter);
            }
            private void createChestplate(ItemConvertible output, ItemConvertible material) {
                createShaped(RecipeCategory.COMBAT, output)
                        .pattern("m m")
                        .pattern("mmm")
                        .pattern("mmm")
                        .input('m', material)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(exporter);
            }
            private void createLeggings(ItemConvertible output, ItemConvertible material) {
                createShaped(RecipeCategory.COMBAT, output)
                        .pattern("mmm")
                        .pattern("m m")
                        .pattern("m m")
                        .input('m', material)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(exporter);
            }
            private void createBoots(ItemConvertible output, ItemConvertible material) {
                createShaped(RecipeCategory.COMBAT, output)
                        .pattern("m m")
                        .pattern("m m")
                        .input('m', material)
                        .criterion(hasItem(material), conditionsFromItem(material))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
