package net.uwulabs.createmate.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.uwulabs.createmate.CreateMate;
import net.uwulabs.createmate.item.ModItems;

import java.util.function.BiConsumer;

public class ModLootTableSubProvider implements LootTableSubProvider {
    public ModLootTableSubProvider(HolderLookup.Provider lookupProvider) {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        output.accept(
                ResourceKey.create(
                        Registries.LOOT_TABLE,
                        ResourceLocation.fromNamespaceAndPath(CreateMate.MOD_ID, "yerba_sapling")
                ),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(
                                        LootItem.lootTableItem(ModItems.YERBA_SAPLING.get())
                                                .when(
                                                        LootItemRandomChanceCondition.randomChance(0.05f)
                                                )
                                )
                )
        );
    }
}
