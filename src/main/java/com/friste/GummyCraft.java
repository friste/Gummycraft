package com.friste;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.friste.core.init.EntityInit;

import java.util.stream.Collectors;

@Mod("gummycraft")
public class GummyCraft {
	public static final String MODID = "gummycraft";
    private static final Logger LOGGER = LogManager.getLogger();
//    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);

    public GummyCraft() {
    	
    	var bus = FMLJavaModLoadingContext.get().getModEventBus();
    	
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
//        MinecraftForge.EVENT_BUS.register(this);
        
        EntityInit.ENTITIES.register(bus);
        
    }
}

//    private void setup(final FMLCommonSetupEvent event)
//    {
//        LOGGER.info("HELLO FROM PREINIT");
//        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
//    }
//    
//
//    private void enqueueIMC(final InterModEnqueueEvent event)
//    {
//        InterModComms.sendTo("gummycraft", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
//    }
//
//    private void processIMC(final InterModProcessEvent event)
//    {
//        LOGGER.info("Got IMC {}", event.getIMCStream().
//                map(m->m.messageSupplier().get()).
//                collect(Collectors.toList()));
//    }
//
//    @SubscribeEvent
//    public void onServerStarting(ServerStartingEvent event) {
//        // do something when the server starts
//        LOGGER.info("HELLO from server starting");
//    }
//
//    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
//    public static class RegistryEvents {
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//            // register a new block here
//            LOGGER.info("HELLO from Register Block");
//        }
//    }
//}
