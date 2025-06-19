package com.theweirdestfrog.tutorialmod.item;

import com.theweirdestfrog.tutorialmod.TutorialMod;
import com.theweirdestfrog.tutorialmod.item.custom.ChiselItem;
import com.theweirdestfrog.tutorialmod.item.custom.FuelItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.item.FireChargeItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(64)));

    public static final DeferredItem<Item> GOLDEN_POTATO = ITEMS.register("golden_potato",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GOLDEN_POTATO)));

    public static final DeferredItem<Item> BLAZE_COAL = ITEMS.register("blaze_coal",
            () -> new FuelItem(new Item.Properties().stacksTo(16), 20000));

    public static final DeferredItem<Item> SOUL_FIRE_CHARGE = ITEMS.register("soul_fire_charge",
            () -> new FireChargeItem(new Item.Properties().stacksTo(96)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
