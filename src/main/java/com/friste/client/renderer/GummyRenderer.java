package com.friste.client.renderer;

import com.friste.client.renderer.model.GummyModel;
import com.friste.common.entity.Gummy;
import com.friste.GummyCraft;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GummyRenderer<Type extends Gummy> extends MobRenderer<Gummy, GummyModel<Gummy>> {
	
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(GummyCraft.MODID, "gummy.png");
	public GummyRenderer(Context p_174304_) {
		super(p_174304_, new GummyModel<Gummy>(p_174304_.bakeLayer(GummyModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Gummy p_114482_) {
		return TEXTURE;
	}

}
