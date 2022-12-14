package com.Casper_233.Fire_Power.items;

import com.Casper_233.Fire_Power.Fire_Power;
import com.Casper_233.Fire_Power.entity.EntityFire_bullet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

//import java.util.logging.Level;

public class ItemFire_bullet extends Item {
    public ItemFire_bullet(Item.Properties name){
        super(name);
    }

    public ItemFire_bullet() {
        super(new Properties().tab(Fire_Power.FIRE_POWER_TAB).stacksTo(128));
    }

    public EntityFire_bullet createArrow(Level level, ItemStack stack, LivingEntity entityIn) {
        return new EntityFire_bullet(level, entityIn);
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant > 0 && this.getClass() == ItemFire_bullet.class;
    }
}
