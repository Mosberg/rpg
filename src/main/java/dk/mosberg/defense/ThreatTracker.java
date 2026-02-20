package dk.mosberg.defense;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks bandit camps and other external threats.
 */
public class ThreatTracker {
    private final Map<String, Integer> banditCamps = new HashMap<>();
    private final Map<String, Integer> monsterThreats = new HashMap<>();

    public void setBanditCamp(String location, int strength) {
        banditCamps.put(location, strength);
    }

    public int getBanditCamp(String location) {
        return banditCamps.getOrDefault(location, 0);
    }

    public void setMonsterThreat(String location, int strength) {
        monsterThreats.put(location, strength);
    }

    public int getMonsterThreat(String location) {
        return monsterThreats.getOrDefault(location, 0);
    }

    public Map<String, Integer> getAllBanditCamps() {
        return banditCamps;
    }

    public Map<String, Integer> getAllMonsterThreats() {
        return monsterThreats;
    }
}
