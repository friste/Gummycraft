package com.friste.client.events;

import com.friste.GummyCraft;

import com.friste.client.renderer.model.GummyModel;

import com.friste.core.init.EntityInit;

import com.friste.client.renderer.GummyRenderer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;

@Mod.EventBusSubscriber(modid = GummyCraft.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
	private ClientModEvents() {}
	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(GummyModel.LAYER_LOCATION, GummyModel::createBodyLayer);
	}
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityInit.GUMMY.get(), GummyRenderer::new);
	}
}
