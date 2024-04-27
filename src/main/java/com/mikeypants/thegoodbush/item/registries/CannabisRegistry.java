package com.mikeypants.thegoodbush.item.registries;

import com.mikeypants.thegoodbush.lib.tuples.CannabisItemsTuple4;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import static com.mikeypants.thegoodbush.item.ModItems.SIMPLEITEMS;

public class CannabisRegistry {
    public static CannabisItemsTuple4 registerCannabisType(String name, RegistryObject<Block> block){
        var seed = SIMPLEITEMS.register(name + "_cannabis_seeds", () -> new ItemNameBlockItem(block.get(), new Item.Properties()));
        var leaf = SIMPLEITEMS.register(name + "_cannabis_leaf", () -> new Item(new Item.Properties()));
        var bud = SIMPLEITEMS.register(name + "_cannabis_bud", () -> new Item(new Item.Properties()));
        var stem = SIMPLEITEMS.register(name + "_cannabis_stem", () -> new Item(new Item.Properties()));

        return new CannabisItemsTuple4(seed, leaf, bud, stem);
    }
}
