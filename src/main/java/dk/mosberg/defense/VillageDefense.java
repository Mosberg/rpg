package dk.mosberg.defense;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks and manages village guards and patrols.
 */
public class VillageDefense {
    private final Map<String, Integer> guardCounts = new HashMap<>();
    private int alertLevel = 0;

    public void setGuardCount(String type, int count) {
        guardCounts.put(type, count);
    }

    public int getGuardCount(String type) {
        return guardCounts.getOrDefault(type, 0);
    }

    public void setAlertLevel(int level) {
        alertLevel = level;
    }

    public int getAlertLevel() {
        return alertLevel;
    }

    public Map<String, Integer> getAllGuards() {
        return guardCounts;
    }
}
