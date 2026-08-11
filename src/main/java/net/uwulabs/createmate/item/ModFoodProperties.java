package net.uwulabs.createmate.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public abstract class ModFoodProperties {
    public static final FoodProperties CLUB_MATE_BOTTLE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.25f)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 5 * 20, 1), 1.f)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();

    public static final FoodProperties TSCHUNK_BOTTLE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.25f)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 5 * 20, 1), 1.f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60 * 20, 1), 1.f)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();

    public static final FoodProperties MATE_EXTRACT_BOTTLE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.25f)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 60 * 20, 1), 1.f)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();
}
