package net.daniel.betterminecraft.item;

import net.daniel.betterminecraft.BetterMinecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterMinecraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab INGREDIENTS;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        INGREDIENTS = event.registerCreativeModeTab(new ResourceLocation(BetterMinecraft.MOD_ID, "better_minecraft_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.BRASS_INGOT.get()))
                        .title(Component.translatable("creativemodetab.better_minecraft_tab")));
    }
}
