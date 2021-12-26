package com.friste.common.entity;

import com.friste.core.init.EntityInit;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;

public class Gummy extends Animal {

	public Gummy(EntityType<? extends Animal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
	
	}
	
	@Override
	protected void registerGoals() {
	     this.goalSelector.addGoal(0, new FloatGoal(this));
	     this.goalSelector.addGoal(2, new PanicGoal(this, 2.0D));
	     this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
	     this.goalSelector.addGoal(4, new TemptGoal(this, 1.0D, Ingredient.of(Blocks.BAMBOO.asItem()), false));
	     this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
	     
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.24D);
	}
	
	public boolean canBeLeashed(Player p_29107_) {
	      return false;
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
