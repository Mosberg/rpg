package dk.mosberg.customization;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks job assignments and expansion approvals for the village.
 */
public class VillageManagementMenu {
    private final Map<String, String> jobAssignments = new HashMap<>();
    private final Map<String, Boolean> expansions = new HashMap<>();

    public void assignJob(String villager, String job) {
        jobAssignments.put(villager, job);
    }

    public String getJob(String villager) {
        return jobAssignments.get(villager);
    }

    public Map<String, String> getAllJobAssignments() {
        return jobAssignments;
    }

    public void approveExpansion(String expansion, boolean approved) {
        expansions.put(expansion, approved);
    }

    public boolean isExpansionApproved(String expansion) {
        return expansions.getOrDefault(expansion, false);
    }

    public Map<String, Boolean> getAllExpansions() {
        return expansions;
    }
}
