package com.Casper_233.Fire_Power.entity.render;

import com.Casper_233.Fire_Power.Fire_Power;
import com.Casper_233.Fire_Power.entity.EntityFireCracker;
import com.Casper_233.Fire_Power.entity.model.ModelFireCracker;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderFireCracker extends MobRenderer<EntityFireCracker, ModelFireCracker<EntityFireCracker>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Fire_Power.MOD_ID, "textures/entity/firecracker.png");

    public RenderFireCracker(EntityRendererProvider.Context manager){
        super(manager, new ModelFireCracker<>(manager.bakeLayer(ModelFireCracker.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityFireCracker p_110775_1_){
        return TEXTURE;
    }
}
