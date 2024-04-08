package com.mikeypants.thegoodbush.datagen;

import com.mikeypants.thegoodbush.Main;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.mikeypants.thegoodbush.item.ModItems.*;
import static com.mikeypants.thegoodbush.util.ModTags.Items.*;

public class ModItemTags extends ItemTagsProvider {
    public ModItemTags(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Main.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(CANNABIS_SEED)
                .add(INDICA_SEED.get());
        this.tag(CANNABIS_LEAF)
                .add(INDICA_LEAF.get());
        this.tag(CANNABIS_BUD)
                .add(INDICA_BUD.get());
    }
}
