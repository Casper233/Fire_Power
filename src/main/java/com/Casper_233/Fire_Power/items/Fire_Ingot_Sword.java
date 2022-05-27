package com.Casper_233.Fire_Power.items;

import com.Casper_233.Fire_Power.Fire_Power;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class Fire_Ingot_Sword extends SwordItem {
    public Fire_Ingot_Sword() {
        super(CustomItemTier.PreciseAttack,5, 1, new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB));
    }
}
