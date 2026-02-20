package dk.mosberg.admin;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks admin UI state and debug info for villages.
 */
public class AdminUIState {
    private final Map<String, Object> debugInfo = new HashMap<>();
    private boolean open = false;

    public void setDebugInfo(String key, Object value) {
        debugInfo.put(key, value);
    }

    public Object getDebugInfo(String key) {
        return debugInfo.get(key);
    }

    public Map<String, Object> getAllDebugInfo() {
        return debugInfo;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return open;
    }
}
