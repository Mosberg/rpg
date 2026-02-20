package dk.mosberg.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Villager relationships: families, friendships, rivalries.
 */
public class VillagerRelationships {
    private final Map<String, Integer> relationships = new HashMap<>();

    public void setRelationship(String other, int value) {
        relationships.put(other, value);
    }

    public int getRelationship(String other) {
        return relationships.getOrDefault(other, 0);
    }
}
