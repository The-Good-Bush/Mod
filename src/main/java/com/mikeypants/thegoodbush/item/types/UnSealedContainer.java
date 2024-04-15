package com.mikeypants.thegoodbush.item.types;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class UnSealedContainer extends Item implements DyeableLeatherItem {
    public List<Item> content;
    public UnSealedContainer(Properties properties) {
        super(properties);
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack itemStack, int count) {
        if(entity instanceof Player && itemStack.is(this.asItem())){
            int slot = ((Player) entity).getInventory().findSlotMatchingItem(itemStack);

            ((Player) entity).inventoryMenu.slots.remove(slot);
        }
    }
}
