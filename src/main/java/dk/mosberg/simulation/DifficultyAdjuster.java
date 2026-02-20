package dk.mosberg.simulation;

/**
 * Handles dynamic adjustment of difficulty based on simulation events.
 */
public class DifficultyAdjuster {
    private final DynamicDifficulty difficulty;

    public DifficultyAdjuster(DynamicDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void adjustForRaidSuccess() {
        difficulty.setRaidDifficulty(difficulty.getRaidDifficulty() + 1);
    }

    public void adjustForRaidFailure() {
        difficulty.setRaidDifficulty(Math.max(1, difficulty.getRaidDifficulty() - 1));
    }

    public void adjustForPopulationChange(int delta) {
        difficulty
                .setPopulationDifficulty(Math.max(1, difficulty.getPopulationDifficulty() + delta));
    }

    public void adjustForEconomySync(int syncLevel) {
        difficulty.setEconomySync(syncLevel);
    }
}
