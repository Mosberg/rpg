package dk.mosberg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dk.mosberg.worldgen.RPGVillageWorldgen;
import net.fabricmc.api.ModInitializer;

public class RPG implements ModInitializer {
    public static final String MOD_ID = "rpg";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Register RPG village worldgen
        RPGVillageWorldgen.register();

        LOGGER.info("Village & Villager RPG Expansion initialized!");
    }
}
