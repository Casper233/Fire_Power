package com.Casper_233.Fire_Power.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC = null;

    public static final ForgeConfigSpec.ConfigValue<Integer> FIRE_ELEMENT_ORE_VEIN_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> FIRE_ELEMENT_ORE_VEIN_SIZE;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAI_INGOT_ORE_VEIN_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> TAI_INGOT_ORE_VEIN_SIZE;

    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_FireCracker;

    static {
        BUILDER.push("Configs for Fire Power Mod");

        FIRE_ELEMENT_ORE_VEIN_PER_CHUNK = BUILDER.comment("Numbers of the Fire Element Ore vein per chunk")
                .define("Fire Element Ore Veins Per Chunk", 7);
        TAI_INGOT_ORE_VEIN_PER_CHUNK = BUILDER.comment("Numbers of the Tai Ingot Ore vein per chunk")
                .define("Tai Ingot Ore Veins Per Chunk", 3);

        FIRE_ELEMENT_ORE_VEIN_SIZE = BUILDER.comment("Numbers Fire Element Ore spawn in one vein")
                .defineInRange("Fire Element Ore Vein Size", 3, 1, 5);
        TAI_INGOT_ORE_VEIN_SIZE = BUILDER.comment("Numbers Tai Ingot Ore spawn in one vein")
                .defineInRange("Tai Ingot Ore Vein Size", 4, 1, 6);

        SPAWN_FireCracker = BUILDER.comment("Spawn FireCrackers")
                .define("entity.FireCracker.spawnrate", 13);

    }
}
