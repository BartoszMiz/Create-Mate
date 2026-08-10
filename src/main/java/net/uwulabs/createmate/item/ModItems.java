package net.uwulabs.createmate.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.uwulabs.createmate.CreateMate;
import net.uwulabs.createmate.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

public abstract class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateMate.MOD_ID);

    public static final DeferredItem<Item> CLUB_MATE_BOTTLE = ITEMS.register("club_mate_bottle",
            () -> new Item(
                    new Item.Properties()
                            .food(ModFoodProperties.CLUB_MATE_BOTTLE)
                            .stacksTo(1)
            ) {
                @Override
                public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
                    return UseAnim.DRINK;
                }
            }
    );

    public static final DeferredItem<Item> TSCHUNK_BOTTLE = ITEMS.register("tschunk_bottle",
            () -> new Item(
                    new Item.Properties()
                            .food(ModFoodProperties.TSCHUNK_BOTTLE)
                            .stacksTo(1)
            ) {
                @Override
                public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
                    return UseAnim.DRINK;
                }
            });

    public static final DeferredItem<Item> YERBA_SAPLING = ITEMS.register("yerba_sapling",
            () -> new ItemNameBlockItem(ModBlocks.YERBA_MATE_CROP.get(), new Item.Properties())
    );

    public static final DeferredItem<Item> YERBA_LEAVES = ITEMS.register("yerba_leaves",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> DRIED_YERBA_LEAVES = ITEMS.register("dried_yerba_leaves",
            () -> new Item(new Item.Properties())
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
