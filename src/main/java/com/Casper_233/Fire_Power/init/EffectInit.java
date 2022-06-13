package com.Casper_233.Fire_Power.init;

import com.Casper_233.Fire_Power.Fire_Power;
import com.Casper_233.Fire_Power.effects.EffectBurn;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class EffectInit {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Fire_Power.MOD_ID);

    public static RegistryObject<MobEffect>BURN = EFFECTS.register("burn", () ->{
        return new EffectBurn(MobEffectCategory.HARMFUL, 0x000033, false)
                .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                        "7107DE5E-7CE8-4030-940E-514C1F160890", (double)-0.25F, AttributeModifier.Operation.MULTIPLY_TOTAL);
    });
}
