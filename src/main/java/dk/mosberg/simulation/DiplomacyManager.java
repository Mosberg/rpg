package dk.mosberg.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks and manages diplomacy between villages.
 */
public class DiplomacyManager {
    private final Map<String, Map<String, Integer>> relations = new HashMap<>();

    public void setRelation(String villageA, String villageB, int value) {
        relations.computeIfAbsent(villageA, k -> new HashMap<>()).put(villageB, value);
        relations.computeIfAbsent(villageB, k -> new HashMap<>()).put(villageA, value);
    }

    public int getRelation(String villageA, String villageB) {
        return relations.getOrDefault(villageA, Map.of()).getOrDefault(villageB, 0);
    }

    public Map<String, Integer> getAllRelations(String village) {
        return relations.getOrDefault(village, Map.of());
    }
}
