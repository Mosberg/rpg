package dk.mosberg.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks and manages the world economy chunk system.
 */
public class WorldEconomy {
    private final Map<String, Integer> chunkEconomy = new HashMap<>();

    public void setChunkEconomy(String chunkId, int value) {
        chunkEconomy.put(chunkId, value);
    }

    public int getChunkEconomy(String chunkId) {
        return chunkEconomy.getOrDefault(chunkId, 0);
    }

    public Map<String, Integer> getAllChunkEconomy() {
        return chunkEconomy;
    }
}
