package net.fabricmc.example;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BocchiEntityRenderer extends MobEntityRenderer<BocchiEntity, BocchiEntityModel> {

    public BocchiEntityRenderer(EntityRendererFactory.Context context){
        super(context, new BocchiEntityModel(context.getPart(ExampleModClient.MODEL_BOCCHI_LAYER)),0.75f);
    }

    @Override
    public Identifier getTexture(BocchiEntity entity) {
        return new Identifier("tutorial", "textures/entity/bocchi/bocchi.png");
    }
}
