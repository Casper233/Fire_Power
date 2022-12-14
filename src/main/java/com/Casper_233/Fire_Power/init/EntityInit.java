package com.Casper_233.Fire_Power.init;

import com.Casper_233.Fire_Power.Fire_Power;
import com.Casper_233.Fire_Power.entity.EntityFireCracker;
import com.Casper_233.Fire_Power.entity.EntityFire_bullet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create
            (ForgeRegistries.ENTITIES,Fire_Power.MOD_ID);

    public static final RegistryObject<EntityType<EntityFireCracker>> FIRECRACKER = ENTITY_TYPES
            .register("firecracker", () -> EntityType.Builder.of(EntityFireCracker::new, MobCategory.MONSTER)
                    .sized(0.5F, 3.0F). setTrackingRange(30).build(new ResourceLocation(Fire_Power.MOD_ID,
                            "firecracker").toString()));

    public static final RegistryObject<EntityType<EntityFire_bullet>> FIRE_BULLET = ENTITY_TYPES
            .register("fire_bullet", () -> EntityType.Builder.<EntityFire_bullet>of(EntityFire_bullet::new, MobCategory.MISC).
                    sized(0.25F, 0.25F).setTrackingRange(4).updateInterval(40).
                    build("fire_bullet"));

}