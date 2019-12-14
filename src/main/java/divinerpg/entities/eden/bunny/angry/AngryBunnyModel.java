package divinerpg.entities.eden.bunny.angry;

import divinerpg.entities.base.DivineModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class AngryBunnyModel extends DivineModel<AngryBunny> {
    RendererModel Head;
    RendererModel Body;
    RendererModel Leg1;
    RendererModel Leg2;
    RendererModel Leg3;
    RendererModel Leg4;
    RendererModel Ear1;
    RendererModel Ear2;
    RendererModel Tail;
    RendererModel Shape1;
    RendererModel Shape2;
    RendererModel Shape3;
    RendererModel Shape4;

    public AngryBunnyModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Head = new RendererModel(this, 0, 0);
        this.Head.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4);
        this.Head.setRotationPoint(-1.0F, 13.5F, -7.0F);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.Body = new RendererModel(this, 18, 14);
        this.Body.addBox(-4.0F, -2.0F, -3.0F, 6, 9, 6);
        this.Body.setRotationPoint(0.0F, 14.0F, -3.0F);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, ((float) Math.PI / 2F), 0.0F, 0.0F);
        this.Leg1 = new RendererModel(this, 0, 18);
        this.Leg1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
        this.Leg1.setRotationPoint(-2.5F, 16.0F, 3.0F);
        this.Leg1.setTextureSize(64, 32);
        this.Leg1.mirror = true;
        this.setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
        this.Leg2 = new RendererModel(this, 0, 18);
        this.Leg2.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
        this.Leg2.setRotationPoint(0.5F, 16.0F, 3.0F);
        this.Leg2.setTextureSize(64, 32);
        this.Leg2.mirror = true;
        this.setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
        this.Leg3 = new RendererModel(this, 0, 18);
        this.Leg3.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
        this.Leg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
        this.Leg3.setTextureSize(64, 32);
        this.Leg3.mirror = true;
        this.setRotation(this.Leg3, 0.0F, 0.0F, 0.0F);
        this.Leg4 = new RendererModel(this, 0, 18);
        this.Leg4.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
        this.Leg4.setRotationPoint(0.5F, 16.0F, -4.0F);
        this.Leg4.setTextureSize(64, 32);
        this.Leg4.mirror = true;
        this.setRotation(this.Leg4, 0.0F, 0.0F, 0.0F);
        this.Ear1 = new RendererModel(this, 16, 14);
        this.Ear1.addBox(-3.0F, -5.0F, 0.0F, 2, 2, 1);
        this.Ear1.setRotationPoint(-1.0F, 13.5F, -7.0F);
        this.Ear1.setTextureSize(64, 32);
        this.Ear1.mirror = true;
        this.setRotation(this.Ear1, 0.0F, 0.0F, 0.0F);
        this.Ear2 = new RendererModel(this, 16, 14);
        this.Ear2.addBox(1.0F, -5.0F, 0.0F, 2, 2, 1);
        this.Ear2.setRotationPoint(-1.0F, 13.5F, -7.0F);
        this.Ear2.setTextureSize(64, 32);
        this.Ear2.mirror = true;
        this.setRotation(this.Ear2, 0.0F, 0.0F, 0.0F);
        this.Tail = new RendererModel(this, 6, 0);
        this.Tail.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
        this.Tail.setRotationPoint(-2.0F, 13.0F, 4.0F);
        this.Tail.setTextureSize(64, 32);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.0F, 0.0F, 0.0F);
        this.Shape1 = new RendererModel(this, 50, 18);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Shape1.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
        this.Shape2 = new RendererModel(this, 50, 18);
        this.Shape2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Shape2.setRotationPoint(-4.0F, 9.0F, 0.0F);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
        this.Shape3 = new RendererModel(this, 50, 18);
        this.Shape3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Shape3.setRotationPoint(0.0F, 9.0F, -4.0F);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
        this.Shape4 = new RendererModel(this, 50, 18);
        this.Shape4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
        this.Shape4.setRotationPoint(-4.0F, 9.0F, -4.0F);
        this.Shape4.setTextureSize(64, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void setRotationAngles(AngryBunny entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);

        this.Head.rotateAngleX = headPitch / (180F / (float) Math.PI);
        this.Head.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);
        this.Ear1.rotateAngleX = headPitch / (180F / (float) Math.PI);
        this.Ear1.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);
        this.Ear2.rotateAngleX = headPitch / (180F / (float) Math.PI);
        this.Ear2.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);
        this.Body.rotateAngleX = ((float) Math.PI / 2F);
        this.Leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.Leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.Leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
