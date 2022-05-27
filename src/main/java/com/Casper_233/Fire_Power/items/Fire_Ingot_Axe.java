package com.Casper_233.Fire_Power.items;

import com.Casper_233.Fire_Power.Fire_Power;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;

public class Fire_Ingot_Axe extends AxeItem {
    public Fire_Ingot_Axe() {
        super(CustomItemTier.PreciseAttack,5, 1, new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB));
    }
}
