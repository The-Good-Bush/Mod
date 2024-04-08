package com.mikeypants.thegoodbush.datagen;

import com.mikeypants.thegoodbush.Main;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStates extends BlockStateProvider {
    public ModBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Main.MODID, exFileHelper);
    }
    // TODO: Currently unnecessary
    @Override
    protected void registerStatesAndModels() {

    }
}
