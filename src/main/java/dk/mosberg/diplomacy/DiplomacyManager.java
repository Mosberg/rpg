package dk.mosberg.diplomacy;

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
 * Manages diplomacy, alliances, and multi-village/world simulation.
 * Loads diplomacy data from JSON (future extension).
 */
public class DiplomacyManager {
    private static final Map<String, DiplomacyData> diplomacyData = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger("rpg-diplomacy");
    private static final String DIPLOMACY_PATH = "/data/rpg/diplomacy/diplomacy.json";

    public static void load() {
        diplomacyData.clear();
        try (InputStream stream = DiplomacyManager.class.getResourceAsStream(DIPLOMACY_PATH)) {
            if (stream == null) {
                LOGGER.warn("Diplomacy JSON not found: {} (this is optional for now)", DIPLOMACY_PATH);
                return;
            }
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(new InputStreamReader(stream), JsonObject.class);
            JsonArray relations = root.getAsJsonArray("relations");
            for (int i = 0; i < relations.size(); i++) {
                JsonObject rel = relations.get(i).getAsJsonObject();
                DiplomacyData data = new DiplomacyData(
                    rel.get("villageA").getAsString(),
                    rel.get("villageB").getAsString(),
                    rel.get("status").getAsString()
                );
                diplomacyData.put(data.villageA + ":" + data.villageB, data);
            }
            LOGGER.info("Loaded {} diplomacy relations", diplomacyData.size());
        } catch (Exception e) {
            LOGGER.error("Failed to load diplomacy data", e);
        }
    }

    public static DiplomacyData getRelation(String villageA, String villageB) {
        return diplomacyData.get(villageA + ":" + villageB);
    }

    public static Map<String, DiplomacyData> getAllRelations() {
        return diplomacyData;
    }

    public static class DiplomacyData {
        public final String villageA;
        public final String villageB;
        public final String status;
        public DiplomacyData(String villageA, String villageB, String status) {
            this.villageA = villageA;
            this.villageB = villageB;
            this.status = status;
        }
    }
}
