package com.mikeypants.thegoodbush.datagen.loot;

import com.mikeypants.thegoodbush.block.ModBlocks;
import com.mikeypants.thegoodbush.block.plants.IndicaCannabisCropBlock;
import com.mikeypants.thegoodbush.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Indica Cannabis LootTable
        this.add(ModBlocks.INDICA_CANNABIS_PLANT.get(), createCropDrops(ModBlocks.INDICA_CANNABIS_PLANT.get(),
                ModItems.INDICA_SEED.get(), ModItems.INDICA_STEM.get(),
                PlantDrops(ModBlocks.INDICA_CANNABIS_PLANT.get(), IndicaCannabisCropBlock.AGE, 8)));
    }


    protected LootItemCondition.Builder PlantDrops(Block block, IntegerProperty age, int dropAge){
        return  LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(block)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(age, dropAge));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
