package com.Casper_233.Fire_Power;

import com.Casper_233.Fire_Power.entity.EntityFireCracker;
import com.Casper_233.Fire_Power.entity.model.ModelFireCracker;
import com.Casper_233.Fire_Power.entity.render.RenderFireCracker;
import com.Casper_233.Fire_Power.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fire_Power.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEventSubscriber {

    //@SubscribeEvent
    //public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        //event.registerLayerDefinition(ModelFireCracker.LAYER_LOCATION, ModelFireCracker::createBodyLayer);
    //}

    //@SubscribeEvent
    //public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event){
        //event.registerEntityRenderer(EntityInit.FIRECRACKER.get(), RenderFireCracker::new);
    //}

    //@SubscribeEvent
    //public static void onAttributeCreate(EntityAttributeCreationEvent event){
        //event.put(EntityInit.FIRECRACKER.get(), EntityFireCracker.prepareAttributes().build());
    //}
}
