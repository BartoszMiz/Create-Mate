package net.uwulabs.createmate.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.uwulabs.createmate.CreateMate;
import net.uwulabs.createmate.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public abstract class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateMate.MOD_ID);

    public static final DeferredItem<Item> CLUB_MATE_BOTTLE = ITEMS.register("club_mate_bottle",
            () -> new Item(
                    new Item.Properties()
                            .food(ModFoodProperties.CLUB_MATE_BOTTLE)
                            .stacksTo(16)
            ) {
                @Override
                public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
                    return UseAnim.DRINK;
                }

                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                    tooltipComponents.add(
                            Component.translatable(getTooltipKey(CLUB_MATE_BOTTLE))
                                    .setStyle(
                                            Style.EMPTY
                                                    .withItalic(true)
                                                    .withColor(ChatFormatting.GRAY)
                                    )
                    );
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

                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                    tooltipComponents.add(
                            Component.translatable(getTooltipKey(TSCHUNK_BOTTLE))
                                    .setStyle(
                                            Style.EMPTY
                                                    .withItalic(true)
                                                    .withColor(ChatFormatting.GRAY)
                                    )
                    );
                }
            });

    public static final DeferredItem<Item> YERBA_SAPLING = ITEMS.register("yerba_sapling",
            () -> new ItemNameBlockItem(ModBlocks.YERBA_MATE_CROP.get(), new Item.Properties())
    );

    public static final DeferredItem<Item> YERBA_LEAVES = ITEMS.register("yerba_leaves",
            () -> new Item(new Item.Properties().stacksTo(16))
    );

    public static final DeferredItem<Item> DRIED_YERBA_LEAVES = ITEMS.register("dried_yerba_leaves",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> MATE_EXTRACT_BOTTLE = ITEMS.register("mate_extract_bottle",
            () -> new Item(new Item.Properties()
                    .stacksTo(16)
                    .food(ModFoodProperties.MATE_EXTRACT_BOTTLE)
            ) {
                @Override
                public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
                    return UseAnim.DRINK;
                }
            }
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static String getTooltipKey(DeferredItem<Item> item) {
        return "item." + item.getId().getNamespace() + "." + item.getId().getPath() + ".tooltip";
    }
}
