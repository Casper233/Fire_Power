package com.Casper_233.Fire_Power.init;

import com.Casper_233.Fire_Power.Fire_Power;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockInit {
    //reg
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Fire_Power.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    public static final RegistryObject<Block> FIRE_ELEMENT_BLOCK = register("fire_element_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL,
                    MaterialColor.COLOR_PURPLE).strength(3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB)));

    public static final RegistryObject<Block> FIRE_ELEMENT_ORE = register("fire_element_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE,
                    MaterialColor.COLOR_PURPLE).strength(3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB)));

    public static final RegistryObject<Block> FIRE_INGOT_BLOCK = register("fire_ingot_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL,
                    MaterialColor.COLOR_PURPLE).strength(3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB)));

    public static final RegistryObject<Block> TAI_INGOT_BLOCK = register("tai_ingot_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL,
                    MaterialColor.COLOR_PURPLE).strength(3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB)));

    public static final RegistryObject<Block> TAI_INGOT_ORE = register("tai_ingot_ore", () -> new Block(BlockBehaviour.Properties.of(Material.METAL,
                    MaterialColor.COLOR_PURPLE).strength(3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB)));

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block){
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(final  String name, final Supplier<? extends T> block,
                                                                Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }
}
