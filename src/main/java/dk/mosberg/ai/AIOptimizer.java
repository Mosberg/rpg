package dk.mosberg.ai;

/**
 * Utility for performance tuning and AI optimization.
 */
public class AIOptimizer {
    private final AITickScheduler scheduler;
    private final AIUpdateManager updateManager;

    public AIOptimizer(AITickScheduler scheduler, AIUpdateManager updateManager) {
        this.scheduler = scheduler;
        this.updateManager = updateManager;
    }

    public void optimize() {
        // Example: Remove unscheduled entities from scheduler
        scheduler.getAllTickDelays().keySet().removeIf(id -> !updateManager.isScheduled(id));
    }
}
