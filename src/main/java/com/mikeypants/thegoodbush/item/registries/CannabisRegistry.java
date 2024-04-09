package com.mikeypants.thegoodbush.item.registries;

import com.mikeypants.thegoodbush.lib.tuples.ItemTuple3;
import net.minecraft.world.item.Item;

import static com.mikeypants.thegoodbush.item.ModItems.SIMPLEITEMS;

public class CannabisRegistry {
    // None Empty Items
    public static ItemTuple3 registerCannabisType(String name, Item seed, Item leaf, Item bud){
        var a = SIMPLEITEMS.register(name+ "_cannabis_seed", () -> seed);
        var b = SIMPLEITEMS.register(name + "_cannabis_leaf", () -> leaf);
        var c = SIMPLEITEMS.register(name + "_cannabis_bud", () -> bud);

        return new ItemTuple3(a,b,c);
    }
    // Empty Items
    public static ItemTuple3 registerCannabisType(String name){
        var a = SIMPLEITEMS.register(name+ "_cannabis_seed", () -> new Item(new Item.Properties()));
        var b = SIMPLEITEMS.register(name + "_cannabis_leaf", () -> new Item(new Item.Properties()));
        var c = SIMPLEITEMS.register(name + "_cannabis_bud", () -> new Item(new Item.Properties()));

        return new ItemTuple3(a,b,c);
    }
}
