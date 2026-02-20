package dk.mosberg.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks caravan schedules and travel times.
 */
public class CaravanSchedule {
    private final Map<String, Integer> caravanTimes = new HashMap<>();

    public void setTravelTime(String caravanId, int time) {
        caravanTimes.put(caravanId, time);
    }

    public int getTravelTime(String caravanId) {
        return caravanTimes.getOrDefault(caravanId, 0);
    }

    public Map<String, Integer> getAllTravelTimes() {
        return caravanTimes;
    }
}
