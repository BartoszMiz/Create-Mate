package net.uwulabs.createmate.datagen;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.uwulabs.createmate.CreateMate;
import net.uwulabs.createmate.block.ModBlocks;
import net.uwulabs.createmate.block.YerbaMateCropBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CreateMate.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        getVariantBuilder(ModBlocks.YERBA_MATE_CROP.get()).forAllStates(
                state -> new ConfiguredModel[]{
                        new ConfiguredModel(
                                models().cross(
                                        "yerba_mate_crop_stage" + state.getValue(YerbaMateCropBlock.AGE),
                                        ResourceLocation.fromNamespaceAndPath(
                                                CreateMate.MOD_ID,
                                                "block/" + "yerba_mate_crop_stage" + state.getValue(YerbaMateCropBlock.AGE)
                                        )
                                ).renderType(RenderType.cutout().name)
                        )
                }
        );
    }
}
