package dk.mosberg.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks trade goods and values for each caravan.
 */
public class CaravanTrade {
    private final Map<String, Map<String, Integer>> caravanGoods = new HashMap<>();

    public void setGoods(String caravanId, String good, int amount) {
        caravanGoods.computeIfAbsent(caravanId, k -> new HashMap<>()).put(good, amount);
    }

    public int getGoods(String caravanId, String good) {
        return caravanGoods.getOrDefault(caravanId, Map.of()).getOrDefault(good, 0);
    }

    public Map<String, Integer> getAllGoods(String caravanId) {
        return caravanGoods.getOrDefault(caravanId, Map.of());
    }

    public Map<String, Map<String, Integer>> getAllCaravanGoods() {
        return caravanGoods;
    }
}
