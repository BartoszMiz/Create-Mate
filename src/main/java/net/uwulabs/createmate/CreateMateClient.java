package net.uwulabs.createmate;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.uwulabs.createmate.fluid.ModFluids;
import net.uwulabs.createmate.item.ModItems;
import org.jetbrains.annotations.NotNull;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = CreateMate.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = CreateMate.MOD_ID, value = Dist.CLIENT)
public class CreateMateClient {
    public CreateMateClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        CreateMate.LOGGER.info("HELLO FROM CLIENT SETUP");
        CreateMate.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void onRegisterFluidExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(createTintedWater(0xffcbcf04), ModFluids.MATE_EXTRACT_TYPE.get());
        event.registerFluidType(createTintedWater(0x80fbd905), ModFluids.CLUB_MATE_TYPE.get());
    }

    @SubscribeEvent
    public static void onRegisterItemColors(RegisterColorHandlersEvent.Item event) {
        event.register(
                (stack, tintIndex) -> tintIndex == 1 ? 0xffcbcf04 : -1,
                ModItems.MATE_EXTRACT_BOTTLE.get()
        );
    }


    private static IClientFluidTypeExtensions createTintedWater(int tintColor) {
        return new IClientFluidTypeExtensions() {
            private static final ResourceLocation WATER_STILL = ResourceLocation.withDefaultNamespace("block/water_still");
            private static final ResourceLocation WATER_FLOW = ResourceLocation.withDefaultNamespace("block/water_flow");

            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return WATER_STILL;
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return WATER_FLOW;
            }

            @Override
            public int getTintColor() {
                return tintColor;
            }
        };
    }
}
