package com.mikeypants.thegoodbush.item;

import com.mikeypants.thegoodbush.Main;
import com.mikeypants.thegoodbush.item.types.SealedContainer;
import com.mikeypants.thegoodbush.lib.tuples.ItemTuple3;
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
            () -> new SealedContainer(new Item.Properties()));
    public static final RegistryObject<Item> WEED_BAGGIE = LAYEREDITEMS.register("weed_baggie",
            () -> new SealedContainer(new Item.Properties()));

    // Cannabis Plants
    public static final ItemTuple3 INDICA = registerCannabisType("indica");

    public static final RegistryObject<Item>
            INDICA_SEED = INDICA.a(),
            INDICA_LEAF = INDICA.b(),
            INDICA_BUD = INDICA.c();




}
