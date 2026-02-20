package dk.mosberg.ai;

import java.util.HashSet;
import java.util.Set;

/**
 * Manages which villagers/entities are scheduled for AI updates.
 */
public class AIUpdateManager {
    private final Set<String> scheduledEntities = new HashSet<>();

    public void scheduleEntity(String entityId) {
        scheduledEntities.add(entityId);
    }

    public void unscheduleEntity(String entityId) {
        scheduledEntities.remove(entityId);
    }

    public boolean isScheduled(String entityId) {
        return scheduledEntities.contains(entityId);
    }

    public Set<String> getAllScheduledEntities() {
        return scheduledEntities;
    }
}
