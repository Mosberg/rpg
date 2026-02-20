package dk.mosberg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dk.mosberg.worldgen.RPGVillageWorldgen;
import dk.mosberg.data.DataRegistry;
import dk.mosberg.admin.AdminUI;
import dk.mosberg.ai.VillagerAI;
import dk.mosberg.entity.RPGVillagerEntityInteraction;
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
        // Load all data-driven systems
        DataRegistry.loadAll();
        // Register admin UI and advanced villager AI
        AdminUI.register();
        VillagerAI.register();
        RPGVillagerEntityInteraction.register();
        LOGGER.info("Village & Villager RPG Expansion initialized!");
    }
}
