package com.Casper_233.Fire_Power.items;

import com.Casper_233.Fire_Power.Fire_Power;
import com.Casper_233.Fire_Power.entity.EntityFire_bullet;
import com.Casper_233.Fire_Power.init.ItemInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.world.NoteBlockEvent;
import org.checkerframework.checker.index.qual.PolyUpperBound;

import java.util.function.Predicate;

import static net.minecraft.world.item.BowItem.getPowerForTime;

public class ItemFire_gun extends ProjectileWeaponItem implements Vanishable {
    public ItemFire_gun() {
        super(new Item.Properties().tab(Fire_Power.FIRE_POWER_TAB).stacksTo(1));
    }

    public ItemFire_gun(Item.Properties name) {
        super(name);
    }

    public void releaseUsing(ItemStack p_77615_1_, Level level, LivingEntity p_77615_3_, int p_77615_4_) {
        if (p_77615_3_ instanceof Player) {
            Player Player = (net.minecraft.world.entity.player.Player) p_77615_3_;
            boolean flag = Player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, p_77615_1_) > 0;
            Player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 1, true, true));

            ItemStack itemstack = this.findAmmo(Player);

            int i = this.getUseDuration(p_77615_1_) - p_77615_4_;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_77615_1_, level, Player, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(ItemInit.FIRE_BULLET.get().asItem());
                }

                float f = getPowerForTime(i);
                if (!((double) f < 0.1D)) {
                    boolean flag1 = Player.getAbilities().instabuild || (itemstack.getItem() instanceof ItemFire_bullet && ((ItemFire_bullet) itemstack.getItem()).isInfinite(itemstack, p_77615_1_, Player));
                    if (!level.isClientSide) {
                        ItemFire_bullet arrowitem = (ItemFire_bullet) (itemstack.getItem() instanceof ItemFire_bullet ? itemstack.getItem() : ItemInit.FIRE_BULLET.get().asItem());
                        EntityFire_bullet abstractarrowentity = arrowitem.createArrow(level, itemstack, Player);

                        abstractarrowentity = customArrow(abstractarrowentity);
                        abstractarrowentity.shootFromRotation(Player, Player.getXRot(), Player.getYRot(), 0.2F, f * 30.0F, 0.75F);

                        abstractarrowentity.level.addParticle(ParticleTypes.BUBBLE, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x, abstractarrowentity.position().y, abstractarrowentity.position().z);
                        abstractarrowentity.playSound(SoundEvents.ARROW_SHOOT, 2.5F, 2.5F);


                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, p_77615_1_) > 0) {
                            abstractarrowentity.setSecondsOnFire(100);
                        }

                        p_77615_1_.hurtAndBreak(1, Player, (p_220009_1_) -> {
                            p_220009_1_.broadcastBreakEvent(Player.getUsedItemHand());
                        });


                        abstractarrowentity.level.addParticle(ParticleTypes.BUBBLE_POP, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x * -0.2D, 0.08D, abstractarrowentity.position().z * -0.2D);

                        level.addFreshEntity(abstractarrowentity);
                        Player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 60, 1, true, true));

                    }
                    level.playSound((Player) null, Player.getX(), Player.getY(), Player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.4F, 1.4F / (Player.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !Player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            Player.getInventory().removeItem(itemstack);
                        }
                    }

                    Player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        boolean flag = !this.findAmmo(playerIn).isEmpty();
        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, level, playerIn, handIn, flag);
        if (ret != null) return ret;

        if (!playerIn.getAbilities().instabuild && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            playerIn.startUsingItem(handIn);
            return InteractionResultHolder.consume(itemstack);
        }
    }
    public static float getPowerForTime(int p_185059_0_) {
        float f = (float)p_185059_0_ / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }
    public int getUseDuration(ItemStack p_77626_1_) {
        return 600;
    }


    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_OR_FIREWORK;
    }

    public  EntityFire_bullet customArrow(EntityFire_bullet arrow) {
        return arrow;
    }
    public int getDefaultProjectileRange() {
        return 11;
    }
    protected ItemStack findAmmo(Player player)
    {
        if (this.isMoSpitter(player.getItemInHand(InteractionHand.OFF_HAND)))
        {
            return player.getItemInHand(InteractionHand.OFF_HAND);
        }
        else if (this.isMoSpitter(player.getItemInHand(InteractionHand.MAIN_HAND)))
        {
            return player.getItemInHand(InteractionHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.getInventory().getContainerSize(); ++i)
            {
                ItemStack itemstack = player.getInventory().getItem(i);

                if (this.isMoSpitter(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }
    protected boolean isMoSpitter(ItemStack stack)
    {
        return stack.getItem() instanceof ItemFire_bullet;
    }
}
