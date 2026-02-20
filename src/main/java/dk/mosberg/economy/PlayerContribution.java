package dk.mosberg.economy;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks player contributions and rewards for the village economy.
 */
public class PlayerContribution {
    private final Map<String, Integer> contributions = new HashMap<>();

    public void addContribution(String player, int amount) {
        contributions.put(player, contributions.getOrDefault(player, 0) + amount);
    }

    public int getContribution(String player) {
        return contributions.getOrDefault(player, 0);
    }

    public Map<String, Integer> getAllContributions() {
        return contributions;
    }
}
