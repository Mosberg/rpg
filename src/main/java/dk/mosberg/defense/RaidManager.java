package dk.mosberg.defense;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks and manages ongoing and past raids.
 */
public class RaidManager {
    public static class Raid {
        public final String id;
        public final int wave;
        public final String threatType;
        public final int strength;

        public Raid(String id, int wave, String threatType, int strength) {
            this.id = id;
            this.wave = wave;
            this.threatType = threatType;
            this.strength = strength;
        }
    }

    private final Map<String, Raid> activeRaids = new HashMap<>();

    public void startRaid(String id, int wave, String threatType, int strength) {
        activeRaids.put(id, new Raid(id, wave, threatType, strength));
    }

    public void endRaid(String id) {
        activeRaids.remove(id);
    }

    public Raid getRaid(String id) {
        return activeRaids.get(id);
    }

    public Map<String, Raid> getAllActiveRaids() {
        return activeRaids;
    }
}
