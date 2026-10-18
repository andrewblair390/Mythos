
package com.andrewblair.mythos.items;

import com.andrewblair.mythos.Mythos;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class CelestialBronzeArmorMaterial {

    public static final int BASE_DURABILITY = 37;

    public static final TagKey<Item> REPAIRS_CELESTIAL_BRONZE =
            TagKey.create(
                    BuiltInRegistries.ITEM.key(),
                    Mythos.id("repairs_celestial_bronze")
            );

    public static final ResourceKey<EquipmentAsset> ASSET_KEY =
            ResourceKey.create(
                    EquipmentAssets.ROOT_ID,
                    Mythos.id("celestial_bronze")
            );

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            25,
            SoundEvents.ARMOR_EQUIP_GOLD,
            2.0F,
            0.0F,
            REPAIRS_CELESTIAL_BRONZE,
            ASSET_KEY
    );
}

