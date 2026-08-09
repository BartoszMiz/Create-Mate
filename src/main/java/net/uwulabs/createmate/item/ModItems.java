package net.uwulabs.createmate.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.uwulabs.createmate.CreateMate;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
