package net.uwulabs.createmate.datagen.recipe;

import com.simibubi.create.api.data.recipe.FillingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.uwulabs.createmate.CreateMate;
import net.uwulabs.createmate.fluid.ModFluids;
import net.uwulabs.createmate.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModFillingRecipeProvider extends FillingRecipeGen {
    public ModFillingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMate.MOD_ID);
    }

    GeneratedRecipe

    CLUB_MATE_BOTTLE = create(getItemName(ModItems.CLUB_MATE_BOTTLE), b -> b
            .require(SizedFluidIngredient.of(ModFluids.CLUB_MATE.get(), 250))
            .require(Items.GLASS_BOTTLE)
            .output(ModItems.CLUB_MATE_BOTTLE)
    ),

    MATE_EXTRACT_BOTTLE = create(getItemName(ModItems.MATE_EXTRACT_BOTTLE), b -> b
            .require(SizedFluidIngredient.of(ModFluids.MATE_EXTRACT.get(), 250))
            .require(Items.GLASS_BOTTLE)
            .output(ModItems.MATE_EXTRACT_BOTTLE)
    );
}
