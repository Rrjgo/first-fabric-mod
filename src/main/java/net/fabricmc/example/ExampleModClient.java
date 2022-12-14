package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.example.client.gui.screen.ingame.JukeboxDrawerScreen;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ExampleModClient implements ClientModInitializer {

    public static  final EntityModelLayer MODEL_BOCCHI_LAYER = new EntityModelLayer(new Identifier("tutorial", "bocchi"), "main");


    @Override
    public void onInitializeClient(){
        HandledScreens.register(ExampleMod.JUKEBOX_DRAWER_SCREEN_HANDLER, JukeboxDrawerScreen::new);


        EntityRendererRegistry.register(ExampleMod.BOCCHI, (context) -> {
            return new BocchiEntityRenderer(context);
        });

        EntityModelLayerRegistry.registerModelLayer(MODEL_BOCCHI_LAYER, BocchiEntityModel::getTexturedModelData);
    }
}
