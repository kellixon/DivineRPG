package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelCymesoid;
import divinerpg.objects.entities.entity.vethea.EntityCymesoid;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCymesoid extends RenderLiving<EntityCymesoid> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/cymesoid.png");
	private final ModelCymesoid modelEntity;
    
	public RenderCymesoid(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCymesoid(), 1F);
        modelEntity = (ModelCymesoid) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCymesoid entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityCymesoid> {

	        @Override
	        public Render<? super EntityCymesoid> createRenderFor(RenderManager manager) {
	            return new RenderCymesoid(manager, new ModelCymesoid(), 1F);
	        }
	    }

	}