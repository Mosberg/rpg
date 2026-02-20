package dk.mosberg.quest;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks seasonal events and festival quests.
 */
public class SeasonalEventManager {
    private final Map<String, Boolean> events = new HashMap<>();

    public void startEvent(String eventId) {
        events.put(eventId, false);
    }

    public void completeEvent(String eventId) {
        events.put(eventId, true);
    }

    public boolean isEventCompleted(String eventId) {
        return events.getOrDefault(eventId, false);
    }

    public Map<String, Boolean> getAllEvents() {
        return events;
    }
}
