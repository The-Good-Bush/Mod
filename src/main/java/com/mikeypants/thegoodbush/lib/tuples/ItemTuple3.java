package com.mikeypants.thegoodbush.lib.tuples;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public record ItemTuple3(RegistryObject<Item> a, RegistryObject<Item> b, RegistryObject<Item> c) {
}
