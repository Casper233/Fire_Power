package com.Casper_233.Fire_Power;

import com.Casper_233.Fire_Power.init.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("fire_power")
public class Fire_Power {

    public static final String MOD_ID = "fire_power";
    public static final CreativeModeTab FIRE_POWER_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.FIRE_ELEMENT_BLOCK.get());
        }
    };

    public Fire_Power() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //add items and blocks registration
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        SoundInit.SOUNDS.register(bus);
        EntityInit.ENTITY_TYPES.register(bus);
        EffectInit.EFFECTS.register(bus);
        PotionInit.POTIONS.register(bus);

        DimensionInit.register();

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
    }
}