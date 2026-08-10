package net.uwulabs.createmate.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntries;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.uwulabs.createmate.block.ModBlocks;
import net.uwulabs.createmate.block.YerbaMateCropBlock;
import net.uwulabs.createmate.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableSubProvider extends BlockLootSubProvider {
    protected ModBlockLootTableSubProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(
                ModBlocks.YERBA_MATE_CROP.get(),
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1))
                                        .add(LootItem.lootTableItem(ModItems.YERBA_SAPLING))
                                        .when(
                                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.YERBA_MATE_CROP.get())
                                                        .setProperties(
                                                                StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(YerbaMateCropBlock.AGE, YerbaMateCropBlock.MAX_AGE)
                                                        ).invert()
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.YERBA_SAPLING)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                        )
                                        .when(
                                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.YERBA_MATE_CROP.get())
                                                        .setProperties(
                                                                StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(YerbaMateCropBlock.AGE, YerbaMateCropBlock.MAX_AGE)
                                                        )
                                        )
                        )
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1))
                                        .add(
                                                LootItem.lootTableItem(ModItems.YERBA_LEAVES)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                        )
                                        .when(
                                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.YERBA_MATE_CROP.get())
                                                        .setProperties(
                                                                StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(YerbaMateCropBlock.AGE, YerbaMateCropBlock.MAX_AGE)
                                                        )
                                        )
                        )
        );

    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
