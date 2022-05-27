package com.Casper_233.Fire_Power.items;

import com.Casper_233.Fire_Power.Fire_Power;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

public class Fire_Ingot_Shovel extends ShovelItem {
    public Fire_Ingot_Shovel() {
        super(CustomItemTier.PreciseAttack,3, 1, new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB));
    }
}
