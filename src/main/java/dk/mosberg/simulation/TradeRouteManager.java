package dk.mosberg.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks cross-village trade agreements and route values.
 */
public class TradeRouteManager {
    private final Map<String, Integer> routeValues = new HashMap<>();

    public void setRouteValue(String routeId, int value) {
        routeValues.put(routeId, value);
    }

    public int getRouteValue(String routeId) {
        return routeValues.getOrDefault(routeId, 0);
    }

    public Map<String, Integer> getAllRouteValues() {
        return routeValues;
    }
}
