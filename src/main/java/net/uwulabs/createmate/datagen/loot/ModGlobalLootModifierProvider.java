package net.uwulabs.createmate.datagen.loot;

import net.minecraft.advancements.critereon.*;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.uwulabs.createmate.CreateMate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateMate.MOD_ID);
    }

    @Override
    protected void start() {
        var lootTables = List.of(
                BuiltInLootTables.ABANDONED_MINESHAFT,
                BuiltInLootTables.SIMPLE_DUNGEON,
                BuiltInLootTables.JUNGLE_TEMPLE,
                BuiltInLootTables.DESERT_PYRAMID,
                BuiltInLootTables.SHIPWRECK_SUPPLY,
                BuiltInLootTables.VILLAGE_PLAINS_HOUSE
        );

        add(
                "yerba_sapling",
                new AddTableLootModifier(
                        new LootItemCondition[] {
                                AnyOfCondition.anyOf(
                                        lootTables.stream()
                                                .map(ResourceKey<?>::location)
                                                .map(LootTableIdCondition::builder)
                                                .toArray(LootItemCondition.Builder[]::new)
                                ).build()
                        },
                        ResourceKey.create(
                                Registries.LOOT_TABLE,
                                ResourceLocation.fromNamespaceAndPath(CreateMate.MOD_ID, "yerba_sapling")
                        )
                )
        );

    }
}
