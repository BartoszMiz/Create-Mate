package net.uwulabs.createmate.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.uwulabs.createmate.CreateMate;
import net.uwulabs.createmate.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateMate.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CLUB_MATE_BOTTLE.get());
        basicItem(ModItems.TSCHUNK_BOTTLE.get());
        basicItem(ModItems.YERBA_SAPLING.get());
        basicItem(ModItems.YERBA_LEAVES.get());
        basicItem(ModItems.DRIED_YERBA_LEAVES.get());
    }
}
