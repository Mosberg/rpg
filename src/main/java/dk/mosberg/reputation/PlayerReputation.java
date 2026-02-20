package dk.mosberg.reputation;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks player reputation and influence in a village.
 */
public class PlayerReputation {
    public enum Tier {
        OUTCAST, STRANGER, FRIEND, ALLY, CHAMPION, HONORARY_VILLAGER
    }

    private final Map<String, Integer> reputation = new HashMap<>();

    public void addReputation(String player, int amount) {
        reputation.put(player, reputation.getOrDefault(player, 0) + amount);
    }

    public int getReputation(String player) {
        return reputation.getOrDefault(player, 0);
    }

    public Tier getTier(String player) {
        int rep = getReputation(player);
        if (rep < -50)
            return Tier.OUTCAST;
        if (rep < 0)
            return Tier.STRANGER;
        if (rep < 50)
            return Tier.FRIEND;
        if (rep < 150)
            return Tier.ALLY;
        if (rep < 300)
            return Tier.CHAMPION;
        return Tier.HONORARY_VILLAGER;
    }

    public Map<String, Integer> getAllReputation() {
        return reputation;
    }
}
