package dk.mosberg.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Central loader/registry for all data-driven systems (professions, quests, events, shops, themes, etc.).
 */
public class DataRegistry {
    private static final Logger LOGGER = LoggerFactory.getLogger("rpg-data");
    public static void loadAll() {
        try {
            dk.mosberg.profession.ProfessionDataLoader.load();
            dk.mosberg.quest.QuestManager.load();
            dk.mosberg.event.EventManager.load();
            dk.mosberg.diplomacy.DiplomacyManager.load();
            // TODO: Load shops, themes, and any additional data-driven systems
            LOGGER.info("All data-driven systems loaded successfully.");
        } catch (Exception e) {
            LOGGER.error("Error loading data-driven systems", e);
        }
    }
}
