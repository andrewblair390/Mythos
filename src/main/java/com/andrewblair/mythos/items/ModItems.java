package com.andrewblair.mythos.items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {

    public static final Item CELESTIAL_BRONZE_INGOT = register(
            ModItemIds.CELESTIAL_BRONZE_INGOT,
            Item::new,
            new Item.Properties()
    );

    public static final Item CELESTIAL_BRONZE_HELMET = register(
            ModItemIds.CELESTIAL_BRONZE_HELMET,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            CelestialBronzeArmorMaterial.INSTANCE,
                            ArmorType.HELMET
                    )
                    .durability(ArmorType.HELMET.getDurability(
                            CelestialBronzeArmorMaterial.BASE_DURABILITY
                    ))
    );

    public static final Item CELESTIAL_BRONZE_CHESTPLATE = register(
            ModItemIds.CELESTIAL_BRONZE_CHESTPLATE,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            CelestialBronzeArmorMaterial.INSTANCE,
                            ArmorType.CHESTPLATE
                    )
                    .durability(ArmorType.CHESTPLATE.getDurability(
                            CelestialBronzeArmorMaterial.BASE_DURABILITY
                    ))
    );

    public static final Item CELESTIAL_BRONZE_LEGGINGS = register(
            ModItemIds.CELESTIAL_BRONZE_LEGGINGS,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            CelestialBronzeArmorMaterial.INSTANCE,
                            ArmorType.LEGGINGS
                    )
                    .durability(ArmorType.LEGGINGS.getDurability(
                            CelestialBronzeArmorMaterial.BASE_DURABILITY
                    ))
    );

    public static final Item CELESTIAL_BRONZE_BOOTS = register(
            ModItemIds.CELESTIAL_BRONZE_BOOTS,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            CelestialBronzeArmorMaterial.INSTANCE,
                            ArmorType.BOOTS
                    )
                    .durability(ArmorType.BOOTS.getDurability(
                            CelestialBronzeArmorMaterial.BASE_DURABILITY
                    ))
    );

    public static Item register(
            ResourceKey<Item> itemKey,
            Function<Item.Properties, Item> itemFactory,
            Item.Properties settings
    ) {
        Item item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(
                BuiltInRegistries.ITEM,
                itemKey,
                item
        );

        return item;
    }



    public static void initialize() {
    }
}