package com.lordcovale.umbra.util;


import com.lordcovale.umbra.blocks.TenebrousOre;
import com.lordcovale.umbra.tools.ModItemTier;
import com.lordcovale.umbra.umbra;
import com.lordcovale.umbra.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, umbra.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, umbra.MOD_ID);


    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    //Items
    public static final RegistryObject<Item> TENEBROUS_DUST = ITEMS.register("ten_dust", ItemBase::new);
    public static final RegistryObject<Item> REFINED_TENEBROUS = ITEMS.register("ref_ten", ItemBase::new);
    public static final RegistryObject<Item> TENEBROUS_INGOT = ITEMS.register("ten_ingot", ItemBase::new);

    //Tools
    public static final RegistryObject<PickaxeItem> TENEBROUS_PICK = ITEMS.register("ten_pick",
            () -> new PickaxeItem(ModItemTier.TENEBROUS, 0, -2.4F, new Item.Properties().group(umbra.TAB)));

    //Blocks
    public static final RegistryObject<Block> TENEBROUS_BLOCK = BLOCKS.register("ten_ore", TenebrousOre::new);

    //Block Items
    public static final RegistryObject<Item> TENEBROUS_BLOCK_ITEM = ITEMS.register("ten_ore",
            () -> new BlockItem(TENEBROUS_BLOCK.get(), new Item.Properties().group(umbra.TAB)));


}
