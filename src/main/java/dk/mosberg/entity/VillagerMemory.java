package dk.mosberg.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Persistent memory for RPG villagers: stores player actions, events, and relationships.
 */
public class VillagerMemory {
    private final Map<String, Object> memory = new HashMap<>();

    public void remember(String key, Object value) {
        memory.put(key, value);
    }

    public Object recall(String key) {
        return memory.get(key);
    }

    public boolean hasMemory(String key) {
        return memory.containsKey(key);
    }
}
