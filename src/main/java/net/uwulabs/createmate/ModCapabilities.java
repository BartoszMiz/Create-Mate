package net.uwulabs.createmate;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.uwulabs.createmate.fluid.ModFluids;
import net.uwulabs.createmate.item.ModItems;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = CreateMate.MOD_ID)
public class ModCapabilities {
    private static void registerFluidHandler(RegisterCapabilitiesEvent event, ItemLike item, ItemLike emptyItem, Fluid fluid, int amount) {
        event.registerItem(
                Capabilities.FluidHandler.ITEM,
                (stack, context) -> new IFluidHandlerItem() {
                    @Override
                    public @NotNull ItemStack getContainer() {
                        return new ItemStack(emptyItem);
                    }

                    @Override
                    public int getTanks() {
                        return 1;
                    }

                    @Override
                    public @NotNull FluidStack getFluidInTank(int tank) {
                        return new FluidStack(fluid, amount);
                    }

                    @Override
                    public int getTankCapacity(int tank) {
                        return amount;
                    }

                    @Override
                    public boolean isFluidValid(int tank, @NotNull FluidStack stack) {
                        return false;
                    }

                    @Override
                    public int fill(@NotNull FluidStack resource, @NotNull FluidAction action) {
                        return 0;
                    }

                    @Override
                    public @NotNull FluidStack drain(@NotNull FluidStack resource, @NotNull FluidAction action) {
                        if (resource.isEmpty() || resource.getFluid() != fluid) return FluidStack.EMPTY;
                        return drain(resource.getAmount(), action);
                    }

                    @Override
                    public @NotNull FluidStack drain(int maxDrain, @NotNull FluidAction action) {
                        if (maxDrain >= amount)
                            return new FluidStack(fluid, amount);

                        return FluidStack.EMPTY;
                    }
                },
                item
        );
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        registerFluidHandler(event, ModItems.MATE_EXTRACT_BOTTLE, Items.GLASS_BOTTLE, ModFluids.MATE_EXTRACT.get(), 250);
        registerFluidHandler(event, ModItems.CLUB_MATE_BOTTLE, Items.GLASS_BOTTLE, ModFluids.CLUB_MATE.get(), 250);
    }
}
