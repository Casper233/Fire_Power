package com.Casper_233.Fire_Power.init;

import com.Casper_233.Fire_Power.Fire_Power;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PotionInit {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Fire_Power.MOD_ID);

    public static final RegistryObject<Potion> BURN_POTION = POTIONS.register("burn_potion", () -> new Potion(new MobEffectInstance(EffectInit.BURN.get(), 200, 0)));

}
