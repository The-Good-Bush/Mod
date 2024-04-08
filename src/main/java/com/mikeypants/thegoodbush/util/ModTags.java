package com.mikeypants.thegoodbush.util;


import com.mikeypants.thegoodbush.Main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> CANNABIS_PLANT = tag("cannabis_plant");


        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Main.MODID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> CANNABIS_SEED = tag("cannabis_seed");
        public static final TagKey<Item> CANNABIS_LEAF = tag("cannabis_leaf");
        public static final TagKey<Item> CANNABIS_BUD = tag("cannabis_bud");

        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(Main.MODID, name));
        }
    }
}
