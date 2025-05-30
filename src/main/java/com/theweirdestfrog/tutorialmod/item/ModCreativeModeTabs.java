package com.theweirdestfrog.tutorialmod.item;

import com.theweirdestfrog.tutorialmod.TutorialMod;
import com.theweirdestfrog.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Display;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> TUTORIAL_ITEMS_TAB = CREATIVE_MODE_TAB.register("tutorial_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIN_INGOT.get()))
                    .title(Component.translatable("creativetab.tutorialmod.tutorial_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TIN_INGOT);
                        output.accept(ModItems.RAW_TIN);
                    }).build());


    public static final Supplier<CreativeModeTab> TUTORIAL_BLOCKS_TAB = CREATIVE_MODE_TAB.register("tutorial_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TIN_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "tutorial_items_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.tutorial_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.TIN_BLOCK);
                        output.accept(ModBlocks.TIN_ORE);
                        output.accept(ModBlocks.DEEPSLATE_TIN_ORE);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
