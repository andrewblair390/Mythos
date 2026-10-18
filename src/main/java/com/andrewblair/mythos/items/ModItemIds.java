package com.andrewblair.mythos.items;

import com.andrewblair.mythos.Mythos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {

    public static final ResourceKey<Item> CELESTIAL_BRONZE_INGOT =
            create("celestial_bronze_ingot");

    public static final ResourceKey<Item> CELESTIAL_UPGRADE_TEMPLATE =
            create("celestial_upgrade_template");

    public static final ResourceKey<Item> CELESTIAL_BRONZE_HELMET =
            create("celestial_bronze_helmet");

    public static final ResourceKey<Item> CELESTIAL_BRONZE_CHESTPLATE =
            create("celestial_bronze_chestplate");

    public static final ResourceKey<Item> CELESTIAL_BRONZE_LEGGINGS =
            create("celestial_bronze_leggings");

    public static final ResourceKey<Item> CELESTIAL_BRONZE_BOOTS =
            create("celestial_bronze_boots");

    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(
                Registries.ITEM,
                Mythos.id(name)
        );
    }
}
