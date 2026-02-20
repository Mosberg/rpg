package dk.mosberg.economy;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles villager-to-villager commerce and trade logic.
 */
public class VillagerCommerce {
    private final Map<String, Integer> tradeCounts = new HashMap<>();

    public void recordTrade(String item, int amount) {
        tradeCounts.put(item, tradeCounts.getOrDefault(item, 0) + amount);
    }

    public int getTradeCount(String item) {
        return tradeCounts.getOrDefault(item, 0);
    }

    public Map<String, Integer> getAllTradeCounts() {
        return tradeCounts;
    }
}
