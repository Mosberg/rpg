package dk.mosberg.worldgen;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Loads village type and structure template data from JSON.
 */
public class VillageTemplateRegistry {
    public static final String VILLAGE_TYPES_PATH =
            "data/rpg/village/village_templates/village_types.json";
    public static final String STRUCTURE_CONFIG_PATH =
            "data/rpg/village/village_templates/village_structure_config.json";


    public static List<String> getVillageTypes() {
        try {
            InputStream stream =
                    VillageTemplateRegistry.class.getResourceAsStream("/" + VILLAGE_TYPES_PATH);
            if (stream == null)
                return List.of();
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(new InputStreamReader(stream), JsonObject.class);
            JsonArray arr = root.getAsJsonArray("village_types");
            List<String> types = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                types.add(arr.get(i).getAsString());
            }
            return types;
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }


    public static Map<String, List<String>> getTemplates() {
        try {
            InputStream stream =
                    VillageTemplateRegistry.class.getResourceAsStream("/" + VILLAGE_TYPES_PATH);
            if (stream == null)
                return Map.of();
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(new InputStreamReader(stream), JsonObject.class);
            JsonObject templates = root.getAsJsonObject("templates");
            Map<String, List<String>> map = new HashMap<>();
            for (String key : templates.keySet()) {
                JsonArray arr = templates.getAsJsonArray(key);
                List<String> list = new ArrayList<>();
                for (int i = 0; i < arr.size(); i++) {
                    list.add(arr.get(i).getAsString());
                }
                map.put(key, list);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return Map.of();
        }
    }


    public static Map<String, Object> getStructureConfig() {
        try {
            InputStream stream =
                    VillageTemplateRegistry.class.getResourceAsStream("/" + STRUCTURE_CONFIG_PATH);
            if (stream == null)
                return Map.of();
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(new InputStreamReader(stream), JsonObject.class);
            Map<String, Object> map = new HashMap<>();
            for (String key : root.keySet()) {
                map.put(key, gson.fromJson(root.get(key), Object.class));
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return Map.of();
        }
    }
}
