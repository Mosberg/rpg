package dk.mosberg.customization;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks and manages village customization options and themes.
 */
public class VillageCustomization {
    private String theme = "Rustic";
    private final Map<String, Object> options = new HashMap<>();

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

    public void setOption(String key, Object value) {
        options.put(key, value);
    }

    public Object getOption(String key) {
        return options.get(key);
    }

    public Map<String, Object> getAllOptions() {
        return options;
    }
}
