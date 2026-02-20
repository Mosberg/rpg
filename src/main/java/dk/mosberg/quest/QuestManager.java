package dk.mosberg.quest;

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
 * Manages quest templates and quest progression for villagers and players.
 * Loads quest templates from JSON and registers quest types.
 */
public class QuestManager {
    private static final Map<String, QuestTemplate> questTemplates = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger("rpg-quest");
    private static final String QUESTS_PATH = "/data/rpg/quests/quest_templates.json";

    public static void load() {
        questTemplates.clear();
        try (InputStream stream = QuestManager.class.getResourceAsStream(QUESTS_PATH)) {
            if (stream == null) {
                LOGGER.warn("Quest templates JSON not found: {}", QUESTS_PATH);
                return;
            }
            Gson gson = new Gson();
            JsonObject root = gson.fromJson(new InputStreamReader(stream), JsonObject.class);
            JsonArray quests = root.getAsJsonArray("quest_templates");
            for (int i = 0; i < quests.size(); i++) {
                JsonObject q = quests.get(i).getAsJsonObject();
                QuestTemplate template = new QuestTemplate(
                    q.get("id").getAsString(),
                    q.get("type").getAsString(),
                    q.getAsJsonArray("objectives").toString(),
                    q.getAsJsonArray("rewards").toString()
                );
                questTemplates.put(template.id, template);
            }
            LOGGER.info("Loaded {} quest templates", questTemplates.size());
        } catch (Exception e) {
            LOGGER.error("Failed to load quest templates", e);
        }
    }

    public static QuestTemplate getTemplate(String id) {
        return questTemplates.get(id);
    }

    public static Map<String, QuestTemplate> getQuestTemplates() {
        return questTemplates;
    }

    public static class QuestTemplate {
        public final String id;
        public final String type;
        public final String objectives;
        public final String rewards;
        public QuestTemplate(String id, String type, String objectives, String rewards) {
            this.id = id;
            this.type = type;
            this.objectives = objectives;
            this.rewards = rewards;
        }
    }
}
