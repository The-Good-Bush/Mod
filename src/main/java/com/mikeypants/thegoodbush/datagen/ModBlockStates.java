package com.mikeypants.thegoodbush.datagen;

import com.mikeypants.thegoodbush.Main;
import com.mikeypants.thegoodbush.block.ModBlocks;
import com.mikeypants.thegoodbush.block.plants.IndicaCannabisCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class ModBlockStates extends BlockStateProvider {
    public ModBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Main.MODID, exFileHelper);
    }
    // TODO: Currently unnecessary
    @Override
    protected void registerStatesAndModels() {
        makeCannabisCrop(((CropBlock) ModBlocks.INDICA_CANNABIS_PLANT.get()), "indica_cannabis_stage_", "indica_cannabis_stage_", "indica/");
    }


    public void makeCannabisCrop(CropBlock block, String modelName, String textureName, String plantName){
        Function<BlockState, ConfiguredModel[]> function = state -> cannabisStates(state, block, modelName, textureName, plantName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cannabisStates(BlockState state, CropBlock block, String modelName, String textureName, String plantName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop("block/" + plantName + modelName + state.getValue(((IndicaCannabisCropBlock) block).getAgeProperty()),
                new ResourceLocation(Main.MODID, "block/" + plantName + textureName + state.getValue(((IndicaCannabisCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
}
