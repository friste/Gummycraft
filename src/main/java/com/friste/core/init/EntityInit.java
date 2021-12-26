package com.friste.core.init;

import com.friste.common.entity.Gummy;
import com.friste.GummyCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, GummyCraft.MODID);
	public EntityInit() {}
	public static final RegistryObject<EntityType<Gummy>> GUMMY = ENTITIES.register("gummy",
			() -> EntityType.Builder.of(Gummy::new, MobCategory.CREATURE).sized(0.6f, 0.8f).build(new ResourceLocation(GummyCraft.MODID, "gummy").toString()));
	
}
