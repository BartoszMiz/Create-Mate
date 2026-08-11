package net.uwulabs.createmate.fluid;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.uwulabs.createmate.CreateMate;

public abstract class ModFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, CreateMate.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, CreateMate.MOD_ID);

    public static final DeferredHolder<FluidType, FluidType> MATE_EXTRACT_TYPE = FLUID_TYPES.register("mate_extract",
            () -> new FluidType(
                    FluidType.Properties.create()
                            .descriptionId("fluid." + CreateMate.MOD_ID + ".mate_extract")
                            .density(1000)
                            .viscosity(1000)
                            .temperature(300)
            )
    );

    public static final DeferredHolder<Fluid, Fluid> MATE_EXTRACT= FLUIDS.register("mate_extract",
            () -> new VirtualFluid(MATE_EXTRACT_TYPE)
    );

    public static final DeferredHolder<FluidType, FluidType> CLUB_MATE_TYPE = FLUID_TYPES.register("club_mate",
            () -> new FluidType(
                    FluidType.Properties.create()
                            .descriptionId("fluid." + CreateMate.MOD_ID + ".club_mate")
                            .density(1000)
                            .viscosity(1200)
                            .temperature(300)
            )
    );

    public static final DeferredHolder<Fluid, Fluid> CLUB_MATE = FLUIDS.register("club_mate",
            () -> new VirtualFluid(CLUB_MATE_TYPE)
    );

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        FLUIDS.register(eventBus);
    }
}
