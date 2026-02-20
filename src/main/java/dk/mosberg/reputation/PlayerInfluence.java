package dk.mosberg.reputation;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks player influence for trade, dialogue, and quest access.
 */
public class PlayerInfluence {
    private final Map<String, Integer> influence = new HashMap<>();

    public void addInfluence(String player, int amount) {
        influence.put(player, influence.getOrDefault(player, 0) + amount);
    }

    public int getInfluence(String player) {
        return influence.getOrDefault(player, 0);
    }

    public Map<String, Integer> getAllInfluence() {
        return influence;
    }
}
