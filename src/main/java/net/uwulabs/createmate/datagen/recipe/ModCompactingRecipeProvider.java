package net.uwulabs.createmate.datagen.recipe;

import com.simibubi.create.api.data.recipe.CompactingRecipeGen;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.material.Fluids;
import net.uwulabs.createmate.CreateMate;
import net.uwulabs.createmate.fluid.ModFluids;
import net.uwulabs.createmate.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModCompactingRecipeProvider extends CompactingRecipeGen {
    public ModCompactingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMate.MOD_ID);
    }

    GeneratedRecipe
            MATE_EXTRACT = create(ModFluids.MATE_EXTRACT.getId().getPath(), b -> b
            .require(Fluids.WATER, 250)
            .require(ModItems.DRIED_YERBA_LEAVES)
            .require(ModItems.DRIED_YERBA_LEAVES)
            .requiresHeat(HeatCondition.HEATED)
            .output(ModFluids.MATE_EXTRACT.get(), 250)
    );
}
