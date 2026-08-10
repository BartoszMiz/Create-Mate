package net.uwulabs.createmate.datagen;

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

    private static ResourceLocation blockToLootTableLocation(Block block) {
        return block.getLootTable().location();
    }

    private Holder.Reference<Enchantment> findEnchantment(ResourceKey<Enchantment> key) {
        return registries.lookupOrThrow(key.registryKey()).getOrThrow(key);
    }

    @Override
    protected void start() {
        var blocks = List.of(
                Blocks.SHORT_GRASS,
                Blocks.TALL_GRASS,
                Blocks.FERN,
                Blocks.LARGE_FERN
        );

        add(
                "yerba_sapling",
                new AddTableLootModifier(
                        new LootItemCondition[]{
                                InvertedLootItemCondition.invert(
                                        MatchTool.toolMatches(
                                                ItemPredicate.Builder.item()
                                                        .of(Items.SHEARS)
                                        )
                                ).build(),
                                InvertedLootItemCondition.invert(
                                        MatchTool.toolMatches(
                                                ItemPredicate.Builder.item()
                                                        .withSubPredicate(
                                                                ItemSubPredicates.ENCHANTMENTS,
                                                                ItemEnchantmentsPredicate.enchantments(
                                                                        List.of(new EnchantmentPredicate(
                                                                                findEnchantment(Enchantments.SILK_TOUCH),
                                                                                MinMaxBounds.Ints.atLeast(1)
                                                                        ))
                                                                )
                                                        )
                                        )
                                ).build(),
                                AnyOfCondition.anyOf(
                                        blocks.stream()
                                                .map(ModGlobalLootModifierProvider::blockToLootTableLocation)
                                                .map(LootTableIdCondition.Builder::new)
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
