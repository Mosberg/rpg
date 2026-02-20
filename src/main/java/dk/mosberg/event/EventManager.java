package dk.mosberg.event;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages seasonal and special events. Loads event data from JSON.
 */
public class EventManager {
    private static final Map<String, EventTemplate> seasonalEvents = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger("rpg-event");
    private static final String EVENTS_PATH = "/data/rpg/events/seasonal_events.json";

    public static void load() {
        seasonalEvents.clear();
        try (InputStream stream = EventManager.class.getResourceAsStream(EVENTS_PATH)) {
            if (stream == null) {
                LOGGER.warn("Seasonal events JSON not found: {}", EVENTS_PATH);
                return;
            }
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(new InputStreamReader(stream), JsonObject.class);
            JsonArray events = root.getAsJsonArray("seasonal_events");
            for (int i = 0; i < events.size(); i++) {
                JsonObject e = events.get(i).getAsJsonObject();
                EventTemplate template = new EventTemplate(
                    e.get("id").getAsString(),
                    e.get("season").getAsString(),
                    e.getAsJsonArray("activities").toString(),
                    e.getAsJsonArray("rewards").toString()
                );
                seasonalEvents.put(template.id, template);
            }
            LOGGER.info("Loaded {} seasonal events", seasonalEvents.size());
        } catch (Exception e) {
            LOGGER.error("Failed to load seasonal events", e);
        }
    }

    public static EventTemplate getEvent(String id) {
        return seasonalEvents.get(id);
    }

    public static Map<String, EventTemplate> getSeasonalEvents() {
        return seasonalEvents;
    }

    public static class EventTemplate {
        public final String id;
        public final String season;
        public final String activities;
        public final String rewards;
        public EventTemplate(String id, String season, String activities, String rewards) {
            this.id = id;
            this.season = season;
            this.activities = activities;
            this.rewards = rewards;
        }
    }
}
