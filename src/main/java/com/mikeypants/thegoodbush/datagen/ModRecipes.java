package com.mikeypants.thegoodbush.datagen;

import com.mikeypants.thegoodbush.Main;
import com.mikeypants.thegoodbush.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;


public class ModRecipes extends RecipeProvider implements IConditionBuilder {
    public ModRecipes(PackOutput pOutPut) {
        super(pOutPut);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MASON_JAR.get(), 3)
                .pattern("GCG")
                .pattern("G G")
                .pattern("GGG")
                .define('C', Items.COPPER_INGOT.asItem())
                .define('G', Items.GLASS.asItem())
                .unlockedBy(getHasName(Items.COPPER_INGOT.asItem()), has(Items.COPPER_INGOT.asItem()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WEED_BAGGIE.get(), 6)
                .pattern(" S ")
                .pattern("P P")
                .pattern("PPP")
                .define('S', Items.SLIME_BALL.asItem())
                .define('P', Items.PAPER.asItem())
                .unlockedBy(getHasName(Items.COPPER_INGOT.asItem()), has(Items.COPPER_INGOT.asItem()))
                .save(consumer);
    }


    protected static void oreSmelting(Consumer<FinishedRecipe> consumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(consumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> consumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(consumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> consumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> p_249619_, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(consumer, Main.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
