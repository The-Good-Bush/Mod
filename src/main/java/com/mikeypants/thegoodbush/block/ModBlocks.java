package com.mikeypants.thegoodbush.block;

import com.mikeypants.thegoodbush.Main;
import com.mikeypants.thegoodbush.block.plants.IndicaCannabisCropBlock;
import com.mikeypants.thegoodbush.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    /*public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)));*/
    public static final RegistryObject<Block> INDICA_CANNABIS_PLANT = registerBlock("indica_cannabis_plant",
            () -> new IndicaCannabisCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> supplier){
        RegistryObject<T> ret = BLOCKS.register(name, supplier);
        registerBlockItem(name, ret);
        return ret;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.SIMPLEITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
