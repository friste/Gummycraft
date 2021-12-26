package com.friste.common.entity;

import com.friste.core.init.EntityInit;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;

public class Gummy extends TamableAnimal {

	public Gummy(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setTame(false);
	}
	
	@Override
	protected void registerGoals() {
	     this.goalSelector.addGoal(0, new FloatGoal(this));
	     this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
	     this.goalSelector.addGoal(4, new TemptGoal(this, 1.0D, Ingredient.of(Items.RABBIT), false));
	     this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.5F));
	     this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
	     this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	     
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.2F);
	}
	
	public InteractionResult mobInteract(Player p_28153_, InteractionHand p_28154_) {
		ItemStack itemstack = p_28153_.getItemInHand(p_28154_);
		Item item = itemstack.getItem();
	    if (this.level.isClientSide) {
         if (this.isTame() && this.isOwnedBy(p_28153_)) {
            return InteractionResult.SUCCESS;
         } else {
            return !this.isFood(itemstack) || !(this.getHealth() < this.getMaxHealth()) && this.isTame() ? InteractionResult.PASS : InteractionResult.SUCCESS;
         }
	    } else {
	     if (itemstack.is(Items.RABBIT)) {
	    	 if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_28153_)) {
	               this.tame(p_28153_);
	               this.navigation.stop();
	               this.setTarget((LivingEntity)null);
	               this.level.broadcastEntityEvent(this, (byte)7);
	            } else {
	               this.level.broadcastEntityEvent(this, (byte)6);
	            }
	     }
         if (this.isTame()) {
            if (this.isOwnedBy(p_28153_)) {
               if (!(item instanceof DyeItem)) {
                  if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                     this.usePlayerItem(p_28153_, p_28154_, itemstack);
                     this.heal((float)item.getFoodProperties().getNutrition());
                     return InteractionResult.CONSUME;
                  }

                  InteractionResult interactionresult = super.mobInteract(p_28153_, p_28154_);
                  if (!interactionresult.consumesAction() || this.isBaby()) {
                     this.setOrderedToSit(!this.isOrderedToSit());
                  }

                  return interactionresult;
               }

           
                  this.setPersistenceRequired();
                  return InteractionResult.CONSUME;
               }
            }
         } if (this.isFood(itemstack)) {
            this.usePlayerItem(p_28153_, p_28154_, itemstack);
            if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_28153_)) {
               this.tame(p_28153_);
               this.setOrderedToSit(true);
               this.level.broadcastEntityEvent(this, (byte)7);
            } else {
               this.level.broadcastEntityEvent(this, (byte)6);
            }

            this.setPersistenceRequired();
            return InteractionResult.CONSUME;
         }

         InteractionResult interactionresult1 = super.mobInteract(p_28153_, p_28154_);
         if (interactionresult1.consumesAction()) {
            this.setPersistenceRequired();
         }

         return interactionresult1;
      }
   	
	
	public boolean canBeLeashed(Player p_29107_) {
	      return true;
	   }
	
	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return EntityInit.GUMMY.get().create(p_146743_);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.SILVERFISH_AMBIENT;
	}
	
	protected SoundEvent getHurtSound() {
		return SoundEvents.SILVERFISH_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.SILVERFISH_DEATH;
	}


}
