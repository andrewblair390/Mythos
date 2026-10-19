
package com.andrewblair.mythos.blocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public final class ModBlocks {

    private ModBlocks() {}

    private static Block register(
            BlockItemId id,
            Function<BlockBehaviour.Properties, Block> factory,
            BlockBehaviour.Properties properties
    ) {
        Block block = Registry.register(
                BuiltInRegistries.BLOCK,
                id.block(),
                factory.apply(properties.setId(id.block()))
        );

        BlockItem blockItem = new BlockItem(
                block,
                new Item.Properties()
                        .useBlockDescriptionPrefix()
                        .setId(id.item())
        );

        Registry.register(
                BuiltInRegistries.ITEM,
                id.item(),
                blockItem
        );

        return block;
    }

    public static final Block HOLY_DIRT = register(
            ModBlockItemIds.HOLY_DIRT,
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)
    );

    public static final Block HOLY_GRASS = register(
            ModBlockItemIds.HOLY_GRASS,
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)
    );

    public static final Block HOLY_STONE = register(
            ModBlockItemIds.HOLY_STONE,
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
    );


    public static void initialize() {
        // Forces static registration when called from Mythos.
    }
}
