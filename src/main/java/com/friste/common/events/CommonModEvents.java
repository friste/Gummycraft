package com.friste.common.events;

import com.friste.common.entity.Gummy;
import com.friste.GummyCraft;
import com.friste.core.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = GummyCraft.MODID, bus = Bus.MOD)
public class CommonModEvents {
	@SubscribeEvent
	public static void registerAttribute(EntityAttributeCreationEvent event) {
		event.put(EntityInit.GUMMY.get(), Gummy.createAttributes().build());
	}
}
