package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelTheHunger;
import divinerpg.objects.entities.entity.vethea.EntityTheHunger;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTheHunger extends RenderLiving<EntityTheHunger> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/the_hunger.png");

    public RenderTheHunger(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTheHunger(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTheHunger entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityTheHunger> {
        @Override
        public Render<? super EntityTheHunger> createRenderFor(RenderManager manager) {
            return new RenderTheHunger(manager, new ModelTheHunger(), 0F);
        }
    }
}