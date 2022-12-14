package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.example.client.gui.screen.ingame.JukeboxDrawerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class ExampleModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient(){
        HandledScreens.register(ExampleMod.JUKEBOX_DRAWER_SCREEN_HANDLER, JukeboxDrawerScreen::new);
    }
}
