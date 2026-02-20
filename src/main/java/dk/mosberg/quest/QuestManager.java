package dk.mosberg.quest;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages all quests for a village, including active and completed.
 */
public class QuestManager {
    private final Map<String, Quest> activeQuests = new HashMap<>();
    private final Map<String, Quest> completedQuests = new HashMap<>();

    public void addQuest(Quest quest) {
        activeQuests.put(quest.getId(), quest);
    }

    public void completeQuest(String id) {
        Quest quest = activeQuests.remove(id);
        if (quest != null) {
            quest.setCompleted(true);
            completedQuests.put(id, quest);
        }
    }

    public Quest getQuest(String id) {
        return activeQuests.get(id);
    }

    public Map<String, Quest> getActiveQuests() {
        return activeQuests;
    }

    public Map<String, Quest> getCompletedQuests() {
        return completedQuests;
    }
}
