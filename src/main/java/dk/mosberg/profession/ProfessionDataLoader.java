package dk.mosberg.profession;

import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Loads profession data from JSON for data-driven extension.
 */
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class ProfessionDataLoader {
    public static final String PROFESSIONS_PATH = "/data/rpg/villager/professions.json";

    public static void load() {
        try {
            InputStream stream = ProfessionDataLoader.class.getResourceAsStream(PROFESSIONS_PATH);
            if (stream == null)
                return;
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(new InputStreamReader(stream), JsonObject.class);
            JsonArray professions = root.getAsJsonArray("professions");
            for (int i = 0; i < professions.size(); i++) {
                JsonObject prof = professions.get(i).getAsJsonObject();
                String id = prof.get("id").getAsString();
                // String display = prof.get("display").getAsString();
                // Optionally parse color, perks, etc.
                ProfessionType type;
                try {
                    type = ProfessionType.valueOf(id.toUpperCase());
                } catch (IllegalArgumentException e) {
                    continue; // skip unknown
                }
                ProfessionRegistry.register(id, type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
