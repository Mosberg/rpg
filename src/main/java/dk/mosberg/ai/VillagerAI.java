package dk.mosberg.ai;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Advanced villager AI: memory, relationships, routines, and goals.
 * Provides hooks for villager memory, relationships, and routines.
 */
public class VillagerAI {
    private static final Logger LOGGER = LoggerFactory.getLogger("rpg-ai");
    private static final Map<UUID, VillagerMemory> villagerMemories = new HashMap<>();

    public static void register() {
        // Hook into villager entity registration (stub)
        LOGGER.info("VillagerAI registered (stub)");
    }

    public static VillagerMemory getMemory(UUID villagerId) {
        return villagerMemories.computeIfAbsent(villagerId, VillagerMemory::new);
    }

    public static class VillagerMemory {
        public final UUID villagerId;
        public int happiness = 100;
        public int trust = 50;
        public Map<UUID, Integer> relationships = new HashMap<>();
        public String lastRoutine = "idle";
        public VillagerMemory(UUID villagerId) {
            this.villagerId = villagerId;
        }
        public void rememberInteraction(UUID other, int deltaTrust) {
            relationships.put(other, relationships.getOrDefault(other, 50) + deltaTrust);
        }
        public void setRoutine(String routine) {
            this.lastRoutine = routine;
        }
    }
}
