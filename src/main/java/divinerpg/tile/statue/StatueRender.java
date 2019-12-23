package divinerpg.tile.statue;

import divinerpg.entities.base.DivineModel;
import divinerpg.tile.base.DivineTileEModel;
import divinerpg.utils.CachedTexture;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class StatueRender extends TileEntityRenderer<TileEntityStatue> {
    @Override
    public void render(TileEntityStatue te, double x, double y, double z, float partialTicks, int destroyStage) {
        super.render(te, x, y, z, partialTicks, destroyStage);
        float rotation = 0;

        if (te.hasWorld()) {
            BlockState state = te.getWorld().getBlockState(te.getPos());
            if (state.has(BlockStateProperties.FACING)) {
                Direction direction = state.get(BlockStateProperties.FACING);
                rotation = direction.getHorizontalAngle() * -1;
            }
        }

        this.bindTexture(findResource(te));

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.7F, (float) z + 0.5F);
        GL11.glScaled(0.5, 0.5, 0.5);

        GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);

        renderModel(te, 0.0625F);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

    private ResourceLocation findResource(TileEntityStatue te) {
        return CachedTexture.ENTITIES.getTexture(te.getName().replace("_statue", ""));
    }

    private void renderModel(TileEntityStatue te, float scale) {
        Model model = StatueConstants.get(te.getName());

        if (model instanceof DivineModel) {
            ((DivineModel) model).render(null, 0, 0, 0, 0, 0, scale);
            return;
        }

        if (model instanceof DivineTileEModel) {
            ((DivineTileEModel) model).render(te, scale);
            return;
        }
    }
}
