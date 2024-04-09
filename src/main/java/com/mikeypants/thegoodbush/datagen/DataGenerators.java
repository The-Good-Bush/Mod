package com.mikeypants.thegoodbush.datagen;

import com.mikeypants.thegoodbush.Main;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Server Sided
        generator.addProvider(event.includeServer(), new ModRecipes(packOutput));
        generator.addProvider(event.includeServer(), ModLootTables.create(packOutput));


        // Client Sided
        generator.addProvider(event.includeClient(), new ModBlockStates(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModels(packOutput, existingFileHelper));


        // Tags
        ModBlockTags blockTags = generator.addProvider(event.includeServer(),
                new ModBlockTags(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));

    }
}
