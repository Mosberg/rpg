package dk.mosberg.quest;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks quest templates for procedural quest generation.
 */
public class QuestTemplateRegistry {
    private final Map<String, Map<String, Object>> templates = new HashMap<>();

    public void addTemplate(String id, Map<String, Object> template) {
        templates.put(id, template);
    }

    public Map<String, Object> getTemplate(String id) {
        return templates.get(id);
    }

    public Map<String, Map<String, Object>> getAllTemplates() {
        return templates;
    }
}
