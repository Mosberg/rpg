package dk.mosberg.customization;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks happiness, productivity, and morale for the village.
 */
public class VillageStats {
    private int happiness = 100;
    private int productivity = 100;
    private int morale = 100;
    private final Map<String, Integer> stats = new HashMap<>();

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getProductivity() {
        return productivity;
    }

    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

    public void setStat(String key, int value) {
        stats.put(key, value);
    }

    public int getStat(String key) {
        return stats.getOrDefault(key, 0);
    }

    public Map<String, Integer> getAllStats() {
        return stats;
    }
}
