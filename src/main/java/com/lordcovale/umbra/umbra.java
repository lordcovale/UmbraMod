package com.lordcovale.umbra;

import com.lordcovale.umbra.util.RegistryHandler;
import com.lordcovale.umbra.world.gen.OreGeneration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("umbra")
public class umbra
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "umbra";

    public static RegistryKey<World> UMBRA_DIMENSION;


    public umbra() {


        //Start Config File

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        RegistryHandler.init();



        // Register the enqueueIMC method for modloading
        // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);


        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    public static final ItemGroup TAB = new ItemGroup("UmbraTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.TENEBROUS_DUST.get());
        }
    };
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        //LOGGER.info("HELLO FROM PREINIT");
        //LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());


        OreGeneration.registerOre();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {


        // do something that can only be done on the client
        //LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);


    }

    //private void enqueueIMC(final InterModEnqueueEvent event)
   // {
        // some example code to dispatch IMC to another mod
        //InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
   // }

    //private void processIMC(final InterModProcessEvent event)
   // {
        // some example code to receive and process InterModComms from other mods
        //LOGGER.info("Got IMC {}", event.getIMCStream().
                //map(m->m.getMessageSupplier().get()).
                //collect(Collectors.toList()));
    //}
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    //@SubscribeEvent
    //public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        //LOGGER.info("HELLO from server starting");
   // }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    //@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    //public static class RegistryEvents {
        //@SubscribeEvent
        //public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            //LOGGER.info("HELLO from Register Block");
       // }
}
