
package com.andrewblair.mythos.blocks;

import com.andrewblair.mythos.Mythos;
import net.minecraft.references.BlockItemId;

public final class ModBlockItemIds {

    private ModBlockItemIds() {}

    private static BlockItemId create(String name) {
        var id = Mythos.id(name);
        return BlockItemId.create(id, id);
    }

    public static final BlockItemId HOLY_STONE =
            create("holy_stone");

    public static final BlockItemId HOLY_DIRT =
            create("holy_dirt");

    public static final BlockItemId HOLY_GRASS =
            create("holy_grass");
}
