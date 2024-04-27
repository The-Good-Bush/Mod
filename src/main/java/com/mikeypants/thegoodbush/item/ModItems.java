package com.mikeypants.thegoodbush.item;

import com.mikeypants.thegoodbush.Main;
import com.mikeypants.thegoodbush.block.ModBlocks;
import com.mikeypants.thegoodbush.item.types.SealedContainer;
import com.mikeypants.thegoodbush.item.types.UnSealedContainer;
import com.mikeypants.thegoodbush.lib.tuples.CannabisItemsTuple4;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.mikeypants.thegoodbush.item.registries.CannabisRegistry.registerCannabisType;


public class ModItems {
    public static final DeferredRegister<Item> SIMPLEITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
    public static final DeferredRegister<Item> LAYEREDITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
    public static void register(IEventBus eventBus) {
        SIMPLEITEMS.register(eventBus);
        LAYEREDITEMS.register(eventBus);
    }

    // Products

    public static final RegistryObject<Item> MASON_JAR = LAYEREDITEMS.register("mason_jar",
            () -> new UnSealedContainer(new Item.Properties(), 32));
    public static final RegistryObject<Item> SEALED_MASON_JAR = LAYEREDITEMS.register("sealed_mason_jar",
            () -> new SealedContainer(new Item.Properties()));
    public static final RegistryObject<Item> WEED_BAGGIE = LAYEREDITEMS.register("weed_baggie",
            () -> new UnSealedContainer(new Item.Properties(), 16));
    public static final RegistryObject<Item> SEALED_WEED_BAGGIE = LAYEREDITEMS.register("sealed_weed_baggie",
            () -> new SealedContainer(new Item.Properties()));

    // Cannabis Plants
    public static final CannabisItemsTuple4 INDICA = registerCannabisType("indica", ModBlocks.INDICA_CANNABIS_PLANT);

    public static final RegistryObject<ItemNameBlockItem> INDICA_SEED = INDICA.seed();
    public static final RegistryObject<Item> INDICA_LEAF = INDICA.leaf();
    public static final RegistryObject<Item> INDICA_BUD = INDICA.bud();
    public static final RegistryObject<Item> INDICA_STEM = INDICA.stem();



}
