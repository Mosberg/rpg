package dk.mosberg.quest;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks long-term story arcs and special events.
 */
public class StoryArcManager {
    private final Map<String, Boolean> storyArcs = new HashMap<>();

    public void startArc(String arcId) {
        storyArcs.put(arcId, false);
    }

    public void completeArc(String arcId) {
        storyArcs.put(arcId, true);
    }

    public boolean isArcCompleted(String arcId) {
        return storyArcs.getOrDefault(arcId, false);
    }

    public Map<String, Boolean> getAllArcs() {
        return storyArcs;
    }
}
