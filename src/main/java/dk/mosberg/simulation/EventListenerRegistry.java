package dk.mosberg.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks event listeners and triggers for simulation events.
 */
public class EventListenerRegistry {
    private final Map<String, Runnable> listeners = new HashMap<>();

    public void registerListener(String event, Runnable callback) {
        listeners.put(event, callback);
    }

    public void triggerEvent(String event) {
        Runnable callback = listeners.get(event);
        if (callback != null)
            callback.run();
    }

    public Map<String, Runnable> getAllListeners() {
        return listeners;
    }
}
