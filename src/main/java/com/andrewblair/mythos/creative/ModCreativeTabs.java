package com.andrewblair.mythos.creative;

import com.andrewblair.mythos.Mythos;
import com.andrewblair.mythos.items.ModItems;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {

    public static final ResourceKey<CreativeModeTab> MYTHOS_TAB_KEY =
            ResourceKey.create(
                    BuiltInRegistries.CREATIVE_MODE_TAB.key(),
                    Mythos.id("mythos_tab")
            );

    public static final CreativeModeTab MYTHOS_TAB =
            FabricCreativeModeTab.builder()
                    .title(Component.translatable("creativeTab.mythos"))
                    .icon(() -> new ItemStack(ModItems.CELESTIAL_BRONZE_INGOT))
                    .displayItems((parameters, output) -> {

                        // Materials
                        output.accept(ModItems.CELESTIAL_BRONZE_INGOT);

                        // Armor
                        output.accept(ModItems.CELESTIAL_BRONZE_HELMET);
                        output.accept(ModItems.CELESTIAL_BRONZE_CHESTPLATE);
                        output.accept(ModItems.CELESTIAL_BRONZE_LEGGINGS);
                        output.accept(ModItems.CELESTIAL_BRONZE_BOOTS);

                    })
                    .build();

    public static void initialize() {
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                MYTHOS_TAB_KEY,
                MYTHOS_TAB
        );
    }
}
