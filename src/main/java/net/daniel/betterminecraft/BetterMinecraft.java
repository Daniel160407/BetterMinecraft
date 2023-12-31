package net.daniel.betterminecraft;

import com.mojang.logging.LogUtils;
import net.daniel.betterminecraft.block.ModBlocks;
import net.daniel.betterminecraft.item.ModCreativeModeTabs;
import net.daniel.betterminecraft.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BetterMinecraft.MOD_ID)
public class BetterMinecraft {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "betterminecraft";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public BetterMinecraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {

            if (event.getTab() == ModCreativeModeTabs.INGREDIENTS) {
                event.accept(ModItems.ZINC_INGOT);
                event.accept(ModItems.BRASS_INGOT);
                event.accept(ModItems.SILVER_INGOT);
                event.accept(ModItems.RAW_SILVER);
                event.accept(ModItems.SILVER_NUGGET);


                event.accept(ModBlocks.ZINC_BLOCK);
                event.accept(ModBlocks.BRASS_BLOCK);
                event.accept(ModBlocks.SILVER_BLOCK);
                event.accept(ModBlocks.SILVER_ORE);
                event.accept(ModBlocks.RAW_SILVER_BLOCK);
                event.accept(ModBlocks.BAOBAB_LOG);
            }
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
