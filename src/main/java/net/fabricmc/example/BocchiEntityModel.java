package net.fabricmc.example;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

public class BocchiEntityModel extends EntityModel<BocchiEntity> {

    private final ModelPart base;

    public BocchiEntityModel(ModelPart modelPart){
        this.base = modelPart.getChild("section_2");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        modelPartData.addChild("section_2", ModelPartBuilder.create()
                .uv(52, 0).cuboid(-1.5F, -6.0F, 13.5F, 3.0F, 6.0F, 3.0F)
                .uv(0, 37).cuboid(-9.0F, -12.0F, -4.5F, 18.0F, 12.0F, 15.0F)
                .uv(0, 0).cuboid(-6.0F, -9.0F, -10.5F, 12.0F, 9.0F, 6.0F)
                .uv(37, 11).cuboid(-10.0F, -10.0F, -8.5F, 3.0F, 1.0F, 1.0F)
                .uv(37, 6).cuboid(-8.0F, -9.0F, -9.5F, 2.0F, 2.0F, 2.0F)
                .uv(37, 0).cuboid(-7.0F, -11.0F, -9.5F, 2.0F, 2.0F, 2.0F)
                .uv(40, 17).cuboid(-4.5F, -9.0F, 10.5F, 9.0F, 9.0F, 3.0F), ModelTransform.pivot(0F, 24F, 0.5F));

        return TexturedModelData.of(modelData, 64, 64);
    }



    @Override
    public void setAngles(BocchiEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.base).forEach((modelRenderer) -> {
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        });
    }
}
