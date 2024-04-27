package com.mikeypants.thegoodbush.block.plants;

import com.mikeypants.thegoodbush.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;

public class IndicaCannabisCropBlock extends CropBlock {

    public static final int BOTTOM_MAX_AGE = 7;
    public static final int TOP_MAX_AGE = 1;

    // <editor-fold desc="Voxel Shapes - Colliders">
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.5D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.5D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.5D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D)
    };
    // </editor-fold>

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0,BOTTOM_MAX_AGE + TOP_MAX_AGE);

    public IndicaCannabisCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_AGE[this.getAge(pState)];
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if(!pLevel.isLoaded(pPos)) return;
        if(pLevel.getRawBrightness(pPos, 0) >= 9) {
            int currentAge = this.getAge(pState);
            if(currentAge < this.getMaxAge()){
                float growthSpeed = getGrowthSpeed(this, pLevel, pPos);

                if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, pPos, pState,
                        pRandom.nextInt((int)(25.0f / growthSpeed) + 1) == 0)){
                    if(currentAge >= BOTTOM_MAX_AGE) {
                        if (pLevel.getBlockState(pPos.above(1)).is(Blocks.AIR))
                            pLevel.setBlock(pPos.above(1), this.getStateForAge(currentAge + 1), 2); // Second Level Growth
                    }
                    else
                        pLevel.setBlock(pPos, this.getStateForAge(currentAge + 1), 2); // First Level Growth

                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
                }
            }
        }

    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return super.mayPlaceOn(state,world,pos);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return super.canSurvive(pState, pLevel, pPos) || pLevel.getBlockState(pPos.below(1)).is(this) &&
                pLevel.getBlockState(pPos.below(1)).getValue(AGE) == 7;
    }

    @Override
    public void growCrops(Level pLevel, BlockPos pPos, BlockState pState) {
        int nextAge = Math.min((this.getAge(pState) + this.getBonemealAgeIncrease(pLevel)), this.getMaxAge());

        if(this.getAge(pState) >= BOTTOM_MAX_AGE && pLevel.getBlockState(pPos.above(1)).is(Blocks.AIR))
            pLevel.setBlock(pPos.above(1), this.getStateForAge(nextAge), 2);
        else
            pLevel.setBlock(pPos, this.getStateForAge(nextAge-TOP_MAX_AGE), 2);
    }

    @Override
    protected int getBonemealAgeIncrease(Level pLevel) {
        return Mth.nextInt(pLevel.random, 1, 2);
    }

    @Override
    public int getMaxAge() {
        return BOTTOM_MAX_AGE + TOP_MAX_AGE;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.INDICA_SEED.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }
}
