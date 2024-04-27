package com.mikeypants.thegoodbush.item.types;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class UnSealedContainer extends Item implements DyeableLeatherItem {
    public ItemStack[] CONTENT;
    private final Properties PROPERTIES;
    private int COLOR;


    public UnSealedContainer(Properties properties, int maxHoldingAmount) {
        super(properties);
        this.PROPERTIES = properties;
        CONTENT = new ItemStack[maxHoldingAmount];
    }

    @Override
    public void setColor(ItemStack itemStack, int color) {
        DyeableLeatherItem.super.setColor(itemStack, color);
        COLOR = color;
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack itemStack, int count) {
        if(entity instanceof Player && itemStack.is(this.asItem())){
            int slot = ((Player) entity).getInventory().findSlotMatchingItem(itemStack);

            // Creating a new SealedContainer and passing current UnSealedContainer ItemStack: properties, content and color
            Item item = new SealedContainer(PROPERTIES).SetContent(CONTENT);
            ItemStack newItem = new ItemStack(item);
            setColor(newItem, COLOR);

            ((Player) entity).inventoryMenu.slots.remove(slot);
            ((Player) entity).inventoryMenu.getSlot(slot).set(newItem);

        }
    }
}
