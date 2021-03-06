package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelHoverStinger;
import divinerpg.objects.entities.entity.vethea.EntityHoverStinger;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHoverStinger extends RenderLiving<EntityHoverStinger> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/hover_stinger.png");
	private final ModelHoverStinger modelEntity;
    
	public RenderHoverStinger(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHoverStinger(), 1F);
        modelEntity = (ModelHoverStinger) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHoverStinger entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityHoverStinger> {

	        @Override
	        public Render<? super EntityHoverStinger> createRenderFor(RenderManager manager) {
	            return new RenderHoverStinger(manager, new ModelHoverStinger(), 1F);
	        }
	    }

	}