package com.mikeypants.thegoodbush.item.types;

import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class SealedContainer extends Item implements DyeableLeatherItem {
    public ItemStack[] content;
    public SealedContainer(Properties properties) {
        super(properties);
    }

    public SealedContainer SetContent(ItemStack[] content){
        this.content = content;
        return this;
    }

    @Override
    public void setColor(ItemStack itemStack, int color) {
        DyeableLeatherItem.super.setColor(itemStack, color);
    }
}
