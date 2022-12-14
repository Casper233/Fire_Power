package com.Casper_233.Fire_Power.entity;

import com.Casper_233.Fire_Power.init.EffectInit;
import com.Casper_233.Fire_Power.init.EntityInit;
import com.Casper_233.Fire_Power.init.ItemInit;
import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.decoration.GlowItemFrame;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class EntityFire_bullet extends ThrowableItemProjectile {
    public double damage;
    private int ticksInGround;
    private static final EntityDataAccessor<Integer> ID_EFFECT_COLOR = SynchedEntityData.defineId(EntityFire_bullet.class, EntityDataSerializers.INT);
    int alpha = 0;

    public EntityFire_bullet(EntityType<?> entityIn, Level level) {
        super((EntityType<? extends EntityFire_bullet>) entityIn, level);
        this.damage = 6.0D;
    }

    public EntityFire_bullet(Level world, LivingEntity entity) {
        super(EntityInit.FIRE_BULLET.get(), entity, world);
        this.damage = 6.0D;
    }

    @Override
    protected Item getDefaultItem() {
        return ItemInit.FIRE_BULLET.get();
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();

        int i = 6;
        if (entity instanceof IronGolem || entity instanceof Ravager) {
            i = 10;
        }
        if (entity instanceof EnderDragon || entity instanceof WitherBoss) {
            i = 12;
        }
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float) (i+random.nextFloat()*.5*this.damage));

        if (entity instanceof ItemFrame) {
            alpha ++;
        }
        else {
            if (random.nextInt(3) == 2) {
                ((LivingEntity) entity).addEffect(new MobEffectInstance(EffectInit.BURN.get(), 2, 0, true, true));
            } else {
                ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 0, true, true));
                ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 6, 1, true, true));
            }
        }
    }

    protected void onHit(EntityHitResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte) 3);
            this.remove(RemovalReason.KILLED);
        }
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        FriendlyByteBuf pack = new FriendlyByteBuf(Unpooled.buffer());
        pack.writeDouble(getX());
        pack.writeDouble(getY());
        pack.writeDouble(getZ());
        pack.writeInt(getId());
        pack.writeUUID(getUUID());
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
