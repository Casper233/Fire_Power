package com.Casper_233.Fire_Power.init;

import com.Casper_233.Fire_Power.Fire_Power;
import com.Casper_233.Fire_Power.items.*;
import net.minecraft.data.Main;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemInit {
    //reg
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Fire_Power.MOD_ID);

    //make items
    public static final RegistryObject<Item> FIRE_ELEMENT = register("fire_element", () -> new Item(new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB)));

    public static final RegistryObject<Item> FIRE_INGOT = register("fire_ingot", () -> new Item(new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB)));

    public static final RegistryObject<Item> TAI_INGOT = register("tai_ingot", () -> new Item(new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB)));

    public static final RegistryObject<Item> OLD_TAI_INGOT = register("old_tai_ingot", () -> new Item(new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB)));

    public static final RegistryObject<Item> FIRE_BREAD = ITEMS.register("fire_bread",
            () -> new Item(new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB).food(new FoodProperties.Builder().nutrition(10)
                    .saturationMod(5).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200 , 0, false, true), 1.0F).
                    effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 1, false, true), 1.0F)
                    .alwaysEat().alwaysEat().build())));

    public static RegistryObject<Item> FIRE_BULLET = ITEMS.register("fire_bullet", () -> {
        return new ItemFire_bullet();
    });


    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }

    public static RegistryObject<Item> Fire_gun = ITEMS.register("fire_gun",()->
    {
        return new ItemFire_gun();
    });

    public static RegistryObject<Item> Fire_Ingot_Sword = register("fire_ingot_sword", () -> {
        return new Fire_Ingot_Sword();
    });

    public static RegistryObject<Item> Fire_Ingot_Axe = register("fire_ingot_axe", () -> {
        return new Fire_Ingot_Axe();
    });

    public static RegistryObject<Item> Fire_Ingot_Pickaxe = register("fire_ingot_pickaxe", () -> {
        return new Fire_Ingot_Pickaxe();
    });

    public static RegistryObject<Item> Fire_Ingot_Hoe = register("fire_ingot_hoe", () -> {
        return new Fire_Ingot_Hoe();
    });

    public static RegistryObject<Item> Fire_Ingot_Shovel = register("fire_ingot_shovel", () -> {
        return new Fire_Ingot_Shovel();
    });

    public static final RegistryObject<Item> FIRE_HELMET = ITEMS.register("fire_helmet",
            () -> new ArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_FIRESUIT, EquipmentSlot.HEAD,
                    (new Item.Properties()).tab(Fire_Power.FIRE_POWER_TAB)));

    public static final RegistryObject<Item> FIRE_CHESTPLATE = ITEMS.register("fire_chest",
            () -> new ArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_FIRESUIT, EquipmentSlot.CHEST,
                    (new Item.Properties()).tab(Fire_Power.FIRE_POWER_TAB)));

    public static final RegistryObject<Item> FIRE_LEGGINGS = ITEMS.register("fire_leggings",
            () -> new ArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_FIRESUIT, EquipmentSlot.LEGS,
                    (new Item.Properties()).tab(Fire_Power.FIRE_POWER_TAB)));

    public static final RegistryObject<Item> FIRE_BOOTS = ITEMS.register("fire_boots",
            () -> new ArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_FIRESUIT, EquipmentSlot.FEET,
                    (new Item.Properties()).tab(Fire_Power.FIRE_POWER_TAB)));

    public static final RegistryObject<Item> FIRECRACKER_SPAWN_EGG = ITEMS.register("firecracker_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FIRECRACKER, 9577503, 13423070, new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB)));

}
