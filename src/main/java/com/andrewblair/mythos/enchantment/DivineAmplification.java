
package com.andrewblair.mythos.enchantment;

import com.andrewblair.mythos.Mythos;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public final class DivineAmplification {

    public static final TagKey<Item> AMPLIFIABLE =
            TagKey.create(
                    Registries.ITEM,
                    Mythos.id("divine_amplification")
            );

    private DivineAmplification() {}

    public static boolean canAmplify(ItemStack stack) {
        return stack.is(AMPLIFIABLE);
    }

    public static int getEffectiveLevel(
            ItemStack stack,
            int storedLevel
    ) {
        if (storedLevel <= 0) {
            return 0;
        }

        return canAmplify(stack)
                ? storedLevel + 1
                : storedLevel;
    }
}
