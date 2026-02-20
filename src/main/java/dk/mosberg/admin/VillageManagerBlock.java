package dk.mosberg.admin;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks and manages village manager blocks.
 */
public class VillageManagerBlock {
    private final Map<String, Object> state = new HashMap<>();

    public void setState(String key, Object value) {
        state.put(key, value);
    }

    public Object getState(String key) {
        return state.get(key);
    }

    public Map<String, Object> getAllState() {
        return state;
    }
}
