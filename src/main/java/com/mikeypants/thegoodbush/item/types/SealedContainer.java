package com.mikeypants.thegoodbush.item.types;

import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;

import java.util.List;

public class SealedContainer extends Item implements DyeableLeatherItem {
    public List<Item> content;
    public SealedContainer(Properties properties) {
        super(properties);
    }

    public void SetContent(List<Item> content){
        this.content = content;
    }
}
