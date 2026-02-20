package dk.mosberg.reputation;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks positive and negative actions for reputation changes.
 */
public class ReputationActions {
    private static final Map<String, Integer> actionValues = new HashMap<>();
    static {
        actionValues.put("train_guard", 20);
        actionValues.put("donate_resources", 10);
        actionValues.put("complete_project", 30);
        actionValues.put("theft", -40);
        actionValues.put("harm_villager", -50);
        actionValues.put("neglect_defense", -20);
        // Add more actions as needed
    }

    public static int getValue(String action) {
        return actionValues.getOrDefault(action, 0);
    }
}
