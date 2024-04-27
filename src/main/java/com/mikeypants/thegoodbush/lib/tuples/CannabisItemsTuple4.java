package com.mikeypants.thegoodbush.lib.tuples;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.RegistryObject;

public record CannabisItemsTuple4(RegistryObject<ItemNameBlockItem> seed, RegistryObject<Item> leaf, RegistryObject<Item> bud, RegistryObject<Item> stem) { }
