package com.Casper_233.Fire_Power.init;

import com.Casper_233.Fire_Power.Fire_Power;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;


public class DimensionInit {

    public static final ResourceKey<Level> FP_KEY = ResourceKey.create
            (Registry.DIMENSION_REGISTRY, new ResourceLocation(Fire_Power.MOD_ID, "fire_power_dimension"));
    public static final ResourceKey<DimensionType> FP_TYPE = ResourceKey.create
            (Registry.DIMENSION_TYPE_REGISTRY, FP_KEY.getRegistryName());

    public static void register() {
        System.out.println("Registering Resident Fire Power Dimension oor" + Fire_Power.MOD_ID);
    }

}
