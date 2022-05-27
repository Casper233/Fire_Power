package com.Casper_233.Fire_Power.items;

import com.Casper_233.Fire_Power.Fire_Power;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;

public class Fire_Ingot_Hoe extends HoeItem {
    public Fire_Ingot_Hoe(){
        super(CustomItemTier.PreciseAttack,3, 1, new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB));
    }
}
