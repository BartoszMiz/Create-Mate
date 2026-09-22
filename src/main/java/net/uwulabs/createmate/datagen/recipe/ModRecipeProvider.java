package net.uwulabs.createmate.datagen.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.uwulabs.createmate.CreateMate;
import net.uwulabs.createmate.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.YERBA_LEAVES),
                        RecipeCategory.MISC,
                        ModItems.DRIED_YERBA_LEAVES,
                        0.1f,
                        200
                )
                .unlockedBy(getHasName(ModItems.YERBA_LEAVES), has(ModItems.YERBA_LEAVES))
                .save(recipeOutput, getRecipeId(ModItems.DRIED_YERBA_LEAVES, "smelting"));

        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(ModItems.YERBA_LEAVES),
                        RecipeCategory.MISC,
                        ModItems.DRIED_YERBA_LEAVES,
                        0.1f,
                        100
                )
                .unlockedBy(getHasName(ModItems.YERBA_LEAVES), has(ModItems.YERBA_LEAVES))
                .save(recipeOutput, getRecipeId(ModItems.DRIED_YERBA_LEAVES, "smoking"));

        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ModItems.YERBA_LEAVES),
                        RecipeCategory.MISC,
                        ModItems.DRIED_YERBA_LEAVES,
                        0.1f,
                        600
                )
               .unlockedBy(getHasName(ModItems.YERBA_LEAVES), has(ModItems.YERBA_LEAVES))
                .save(recipeOutput, getRecipeId(ModItems.DRIED_YERBA_LEAVES, "campfire_cooking"));

    }

    private String getRecipeId(ItemLike result, String processName) {
        return CreateMate.MOD_ID + ":" + getItemName(result) + "_from_" + processName;
    }
}
