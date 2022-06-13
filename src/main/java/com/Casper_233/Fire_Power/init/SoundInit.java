package com.Casper_233.Fire_Power.init;

import com.Casper_233.Fire_Power.Fire_Power;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Fire_Power.MOD_ID);

    public static final RegistryObject<SoundEvent> ENTITY_FireCracker_AMBIENT1 = build("entity.fpg.ambient1");
//    public static final RegistryObject<SoundEvent> ENTITY_FireCracker_AMBIENT2 = build("entity.fpg.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_FireCracker_HURT1 = build("entity.fpg.hurt1");
    public static final RegistryObject<SoundEvent> ENTITY_FireCracker_HURT2 = build("entity.fpg.hurt2");
    public static final RegistryObject<SoundEvent> ENTITY_FireCracker_DEATH1 = build("entity.fpg.death1");
    public static final RegistryObject<SoundEvent> ENTITY_FireCracker_DEATH2 = build("entity.fpg.death2");

    private static RegistryObject<SoundEvent> build(String id){
        return SOUNDS.register(id, () -> new SoundEvent(new ResourceLocation(Fire_Power.MOD_ID, id)));
    }

}
