package dk.mosberg.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks and manages event hooks for weather, calendar, and dimension rules.
 */
public class EventHookManager {
    private final Map<String, Boolean> eventHooks = new HashMap<>();

    public void setEventHook(String event, boolean enabled) {
        eventHooks.put(event, enabled);
    }

    public boolean isEventHookEnabled(String event) {
        return eventHooks.getOrDefault(event, false);
    }

    public Map<String, Boolean> getAllEventHooks() {
        return eventHooks;
    }
}
