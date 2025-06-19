package com.theweirdestfrog.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties GOLDEN_POTATO = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(1f)
            .alwaysEdible()
            .usingConvertsTo(Items.POTATO)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 40, 1), 1f)
            .fast()
            .build();


}
