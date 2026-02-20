package dk.mosberg.ai;

import java.util.HashMap;
import java.util.Map;

/**
 * Schedules and manages async AI ticks for villagers.
 */
public class AITickScheduler {
    private final Map<String, Integer> tickDelays = new HashMap<>();
    private int updateCycle = 20;

    public void setTickDelay(String entityId, int delay) {
        tickDelays.put(entityId, delay);
    }

    public int getTickDelay(String entityId) {
        return tickDelays.getOrDefault(entityId, updateCycle);
    }

    public void setUpdateCycle(int cycle) {
        this.updateCycle = cycle;
    }

    public int getUpdateCycle() {
        return updateCycle;
    }

    public Map<String, Integer> getAllTickDelays() {
        return tickDelays;
    }
}
