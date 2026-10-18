
package com.andrewblair.mythos.mixin;

import com.andrewblair.mythos.enchantment.DivineAmplification;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {

    @ModifyArgs(
            method = "runIterationOnItem("
                    + "Lnet/minecraft/world/item/ItemStack;"
                    + "Lnet/minecraft/world/entity/EquipmentSlot;"
                    + "Lnet/minecraft/world/entity/LivingEntity;"
                    + "Lnet/minecraft/world/item/enchantment/"
                    + "EnchantmentHelper$EnchantmentInSlotVisitor;)V",

            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/enchantment/"
                            + "EnchantmentHelper$EnchantmentInSlotVisitor;"
                            + "accept(Lnet/minecraft/core/Holder;"
                            + "ILnet/minecraft/world/item/enchantment/"
                            + "EnchantedItemInUse;)V"
            ),
            require = 1
    )
    private static void mythos$amplifyEnchantment(
            Args args,
            ItemStack piece,
            EquipmentSlot slot,
            LivingEntity owner,
            EnchantmentHelper.EnchantmentInSlotVisitor visitor
    ) {
        if (owner == null || slot == null) {
            return;
        }

        // Only modify enchantments on currently equipped items.
        if (owner.getItemBySlot(slot) != piece) {
            return;
        }

        if (!DivineAmplification.canAmplify(piece)) {
            return;
        }

        int storedLevel = (Integer) args.get(1);

        int effectiveLevel =
                DivineAmplification.getEffectiveLevel(
                        piece,
                        storedLevel
                );

        args.set(1, effectiveLevel);

    }
}
