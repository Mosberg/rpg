package dk.mosberg.admin;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks and manages admin actions for villages.
 */
public class AdminActionLog {
    private final Map<Long, String> actions = new HashMap<>();

    public void logAction(String action) {
        actions.put(System.currentTimeMillis(), action);
    }

    public Map<Long, String> getAllActions() {
        return actions;
    }
}
