package com.Casper_233.Fire_Power;


import com.google.common.collect.Iterables;
import com.mojang.datafixers.util.Pair;

import net.minecraft.Util;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Mod("fire_power")
public class Fire_Power {
    //blocks and items
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "fire_power");
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "fire_power");

    public static final String FIRE_ELEMENT_ID = "fire_element";
    public static final RegistryObject<Item> FIRE_ELEMENT_ITEM;

    public static final String FIRE_INGOT_ID = "fire_ingot";
    public static final RegistryObject<Item> FIRE_INGOT_ITEM;

    public static final String TAI_INGOT_ID = "tai_ingot";
    public static final RegistryObject<Item> TAI_INGOT_ITEM;

    public static final String OLD_TAI_INGOT_ID = "old_tai_ingot";
    public static final RegistryObject<Item> OLD_TAI_INGOT_ITEM;


    public static final String FIRE_ELEMENT_BLOCK_ID = "fire_element_block";
    public static final RegistryObject<Block> FIRE_ELEMENT_BLOCK;
    public static final RegistryObject<BlockItem> FIRE_ELEMENT_BLOCK_ITEM;

    public static final String FIRE_INGOT_BLOCK_ID = "fire_ingot_block";
    public static final RegistryObject<Block> FIRE_INGOT_BLOCK;
    public static final RegistryObject<BlockItem> FIRE_INGOT_BLOCK_ITEM;

    public static final String TAI_INGOT_BLOCK_ID = "tai_ingot_block";
    public static final RegistryObject<Block> TAI_INGOT_BLOCK;
    public static final RegistryObject<BlockItem> TAI_INGOT_BLOCK_ITEM;

    public static final String FIRE_ELEMENT_ORE_ID = "fire_element_ore";

    public static final RegistryObject<Block> FIRE_ELEMENT_ORE;

    public static final RegistryObject<BlockItem> FIRE_ELEMENT_ORE_ITEM;


    static {
        FIRE_ELEMENT_ITEM = ITEMS.register(FIRE_ELEMENT_ID,
                () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
        FIRE_INGOT_ITEM = ITEMS.register(FIRE_INGOT_ID,
                () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
        TAI_INGOT_ITEM = ITEMS.register(TAI_INGOT_ID,
                () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
        OLD_TAI_INGOT_ITEM = ITEMS.register(OLD_TAI_INGOT_ID,
                () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
        FIRE_ELEMENT_BLOCK = BLOCKS.register(FIRE_ELEMENT_BLOCK_ID,
                () -> new Block(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3F, 1.5F)));
        FIRE_ELEMENT_BLOCK_ITEM = ITEMS.register(FIRE_ELEMENT_BLOCK_ID,
                () -> new BlockItem(FIRE_ELEMENT_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
        FIRE_ELEMENT_ORE = BLOCKS.register(FIRE_ELEMENT_ORE_ID,
                () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3F, 1.5F)));
        FIRE_ELEMENT_ORE_ITEM = ITEMS.register(FIRE_ELEMENT_ORE_ID,
                () -> new BlockItem(FIRE_ELEMENT_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
        FIRE_INGOT_BLOCK = BLOCKS.register(FIRE_INGOT_BLOCK_ID,
                () -> new Block(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3F, 1.5F)));
        FIRE_INGOT_BLOCK_ITEM = ITEMS.register(FIRE_INGOT_BLOCK_ID,
                () -> new BlockItem(FIRE_INGOT_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
        TAI_INGOT_BLOCK = BLOCKS.register(TAI_INGOT_BLOCK_ID,
                () -> new Block(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3F, 1.5F)));
        TAI_INGOT_BLOCK_ITEM = ITEMS.register(TAI_INGOT_BLOCK_ID,
                () -> new BlockItem(TAI_INGOT_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    }

    //public Fire_Power
    public Fire_Power(){
        MinecraftForge.EVENT_BUS.addListener(Fire_Power::onLoggedIn);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Fire_Power::onGatherData);
        //blocks and items
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }



    //message part
    public static void onLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        var player = event.getPlayer();
        player.sendMessage(new TranslatableComponent("chat.message.welcome"), Util.NIL_UUID);
    }

    public static void onGatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var helper = event.getExistingFileHelper();
        gen.addProvider(new EnglishLanguageProvider(gen));
        gen.addProvider(new ChineseLanguageProvider(gen));
        gen.addProvider(new ModelProvider(gen, helper));
        gen.addProvider(new StateProvider(gen, helper));
        gen.addProvider(new LootProvider(gen));
    }


    //English
    public static class EnglishLanguageProvider extends LanguageProvider {
        public EnglishLanguageProvider(DataGenerator gen) {
            super(gen, "fire_power", "en_us");
        }

        @Override
        protected void addTranslations() {
            this.add("chat.message.welcome", "Have a nice day!");
            this.add(FIRE_ELEMENT_ITEM.get(), "Fire Element");
            this.add(FIRE_ELEMENT_BLOCK.get(), "Fire Element Block");
            this.add(FIRE_ELEMENT_ORE.get(), "Fire Element Ore");
            this.add(FIRE_INGOT_ITEM.get(), "Fire Ingot");
            this.add(TAI_INGOT_ITEM.get(), "'Tai' Ingot");
            this.add(FIRE_INGOT_BLOCK.get(), "Fire Ingot Block");
            this.add(TAI_INGOT_BLOCK.get(), "'Tai' Ingot Block");
            this.add(OLD_TAI_INGOT_ITEM.get(), "'Tai' Ingot (Old)");
        }
    }


    //Chinese
    public static class ChineseLanguageProvider extends LanguageProvider {
        public ChineseLanguageProvider(DataGenerator gen) {
            super(gen, "fire_power", "zh_cn");
        }

        @Override
        protected void addTranslations() {
            this.add("chat.message.welcome", "欢迎回来，祝君好运，玩的开心！");
            this.add(FIRE_ELEMENT_ITEM.get(), "火元素");
            this.add(FIRE_ELEMENT_BLOCK.get(), "火元素块");
            this.add(FIRE_ELEMENT_ORE.get(), "火元素矿石");
            this.add(FIRE_INGOT_ITEM.get(), "火锭");
            this.add(TAI_INGOT_ITEM.get(), "钛金锭");
            this.add(FIRE_INGOT_BLOCK.get(), "火锭块");
            this.add(TAI_INGOT_BLOCK.get(), "钛金块");
            this.add(OLD_TAI_INGOT_ITEM.get(), "钛金锭（已经废弃）");
        }
    }

    //Blocks and Items
    public static class ModelProvider extends ItemModelProvider {
        public ModelProvider(DataGenerator gen, ExistingFileHelper helper) {
            super(gen, "fire_power", helper);
        }
        @Override
        protected void registerModels(){
            this.singleTexture(FIRE_ELEMENT_ID, new ResourceLocation("item/generated"), "layer0", new ResourceLocation("fire_power", "item/" + FIRE_ELEMENT_ID));
            this.singleTexture(FIRE_INGOT_ID, new ResourceLocation("item/generated"), "layer0", new ResourceLocation("fire_power", "item/" + FIRE_INGOT_ID));
            this.singleTexture(TAI_INGOT_ID, new ResourceLocation("item/generated"), "layer0", new ResourceLocation("fire_power", "item/" + TAI_INGOT_ID));
            this.singleTexture(OLD_TAI_INGOT_ID, new ResourceLocation("item/generated"), "layer0", new ResourceLocation("fire_power", "item/" + OLD_TAI_INGOT_ID));
        }
    }

    public static class StateProvider extends BlockStateProvider {
        public StateProvider(DataGenerator gen, ExistingFileHelper helper) {
            super(gen, "fire_power", helper);
        }
        @Override
        protected void registerStatesAndModels() {
            this.simpleBlock(FIRE_ELEMENT_BLOCK.get(), this.cubeAll(FIRE_ELEMENT_BLOCK.get()));
            this.simpleBlockItem(FIRE_ELEMENT_BLOCK.get(), this.cubeAll(FIRE_ELEMENT_BLOCK.get()));
            this.simpleBlock(FIRE_ELEMENT_ORE.get(), this.cubeAll(FIRE_ELEMENT_ORE.get()));
            this.simpleBlockItem(FIRE_ELEMENT_ORE.get(), this.cubeAll(FIRE_ELEMENT_ORE.get()));
            this.simpleBlock(FIRE_INGOT_BLOCK.get(), this.cubeAll(FIRE_INGOT_BLOCK.get()));
            this.simpleBlockItem(FIRE_INGOT_BLOCK.get(), this.cubeAll(FIRE_INGOT_BLOCK.get()));
            this.simpleBlock(TAI_INGOT_BLOCK.get(), this.cubeAll(TAI_INGOT_BLOCK.get()));
            this.simpleBlockItem(TAI_INGOT_BLOCK.get(), this.cubeAll(TAI_INGOT_BLOCK.get()));
        }
    }

    //dropping
    public static class LootProvider extends LootTableProvider {
        public LootProvider(DataGenerator gen) {
            super(gen);
        }
        @Nonnull
        @Override
        protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
            return List.of(Pair.of(CustomBlockLoot::new, LootContextParamSets.BLOCK));
        }
        @Override
        protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext context) {
            map.forEach((key, value) -> LootTables.validate(context, key, value));
        }
    }

    //dropping sets
    public static class CustomBlockLoot extends BlockLoot {
        @Override
        protected void addTables() {
            this.add(FIRE_ELEMENT_BLOCK.get(), block -> createSingleItemTableWithSilkTouch(block, FIRE_ELEMENT_ITEM.get(), ConstantValue.exactly(9f)));
            this.dropSelf(FIRE_ELEMENT_ORE.get());
            this.dropSelf(FIRE_INGOT_BLOCK.get());
            this.dropSelf(TAI_INGOT_BLOCK.get());
        }

        @Nonnull
        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Iterables.transform(BLOCKS.getEntries(), RegistryObject::get);
        }
    }
}
