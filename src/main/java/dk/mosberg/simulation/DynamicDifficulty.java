package dk.mosberg.simulation;

/**
 * Configurable dynamic difficulty for raids, population, and economy sync.
 */
public class DynamicDifficulty {
    private int raidDifficulty = 1;
    private int populationDifficulty = 1;
    private int economySync = 1;

    public int getRaidDifficulty() {
        return raidDifficulty;
    }

    public void setRaidDifficulty(int raidDifficulty) {
        this.raidDifficulty = raidDifficulty;
    }

    public int getPopulationDifficulty() {
        return populationDifficulty;
    }

    public void setPopulationDifficulty(int populationDifficulty) {
        this.populationDifficulty = populationDifficulty;
    }

    public int getEconomySync() {
        return economySync;
    }

    public void setEconomySync(int economySync) {
        this.economySync = economySync;
    }
}
