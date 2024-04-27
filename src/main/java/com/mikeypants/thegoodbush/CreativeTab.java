package com.mikeypants.thegoodbush;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.mikeypants.thegoodbush.item.ModItems.*;

public class CreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Main.MODID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_TAB_REGISTER.register("creativetab", () -> CreativeModeTab.builder()
            // Set name of tab to display
            .title(Component.translatable("item_group." + Main.MODID + ".creativetab"))
            // Set icon of creative tab
            .icon(() -> new ItemStack(INDICA_LEAF.get()))
            // Add default items to tab
            .displayItems((params, output) -> {

                for(RegistryObject<Item> item : SIMPLEITEMS.getEntries())
                    output.accept(item.get());
//                for(RegistryObject<Block> block : BLOCKS.getEntries())
//                    output.accept(block.get());
            })
            .build()
    );
    public static void register(IEventBus eventBus){
        CREATIVE_TAB_REGISTER.register(eventBus);
    }
}
