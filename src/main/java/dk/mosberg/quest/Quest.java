package dk.mosberg.quest;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a quest with type, objectives, and rewards.
 */
public class Quest {
    public enum Type {
        DELIVERY, CRAFTING, ESCORT, HUNT, BOUNTY, CONSTRUCTION
    }

    private final String id;
    private final Type type;
    private final Map<String, Object> objectives = new HashMap<>();
    private final Map<String, Object> rewards = new HashMap<>();
    private boolean completed = false;

    public Quest(String id, Type type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Map<String, Object> getObjectives() {
        return objectives;
    }

    public Map<String, Object> getRewards() {
        return rewards;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
