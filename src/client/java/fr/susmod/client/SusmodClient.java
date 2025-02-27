package fr.susmod.client;

import fr.susmod.client.RainbowTrailHandler.RainbowTrailHandler;
import net.fabricmc.api.ClientModInitializer;

public class SusmodClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        RainbowTrailHandler.register();
    }
}
