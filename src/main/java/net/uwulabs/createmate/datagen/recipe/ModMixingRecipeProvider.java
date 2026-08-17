package net.uwulabs.createmate.datagen.recipe;

import com.simibubi.create.api.data.recipe.MixingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.uwulabs.createmate.CreateMate;
import net.uwulabs.createmate.fluid.ModFluids;

import java.util.concurrent.CompletableFuture;

public class ModMixingRecipeProvider extends MixingRecipeGen {
    public ModMixingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMate.MOD_ID);
    }

    GeneratedRecipe

    CLUB_MATE = create("club_mate", b -> b
            .require(SizedFluidIngredient.of(ModFluids.CLUB_MATE.get(), 250))
            // Apparently this doesn't work
//            .require(Ingredient.of(new ItemStack(Items.SUGAR, 2)))
            // but this does
            .require(Items.SUGAR)
            .require(Items.SUGAR)
            .output(ModFluids.CLUB_MATE.get(), 250)
    );
}

