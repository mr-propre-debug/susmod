package fr.susmod;

import fr.susmod.ModBlocks.ModBlocks;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.susmod.ModItems.ModItems;
import fr.susmod.CustomSounds.CustomSounds;

public class Susmod implements ModInitializer {

    public static final String MOD_ID = "susmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        LOGGER.info("Hello Fabric world!");
        CustomSounds.initialize();
        ModItems.initialize();
        ModBlocks.initialize();
    }


}
