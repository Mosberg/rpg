package dk.mosberg.economy;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a village's treasury and shared resources.
 */
public class VillageTreasury {
    private int emeralds = 0;
    private final Map<String, Integer> resources = new HashMap<>();

    public int getEmeralds() {
        return emeralds;
    }

    public void addEmeralds(int amount) {
        emeralds += amount;
    }

    public void removeEmeralds(int amount) {
        emeralds = Math.max(0, emeralds - amount);
    }

    public void addResource(String resource, int amount) {
        resources.put(resource, resources.getOrDefault(resource, 0) + amount);
    }

    public int getResource(String resource) {
        return resources.getOrDefault(resource, 0);
    }

    public Map<String, Integer> getAllResources() {
        return resources;
    }
}
