package dk.mosberg.ai;

/**
 * Provides configuration for AI tick/update cycles.
 */
public class AIConfig {
    private int minTickDelay = 10;
    private int maxTickDelay = 40;
    private int populationCap = 50;
    private int structureDensity = 10;

    public int getMinTickDelay() {
        return minTickDelay;
    }

    public void setMinTickDelay(int minTickDelay) {
        this.minTickDelay = minTickDelay;
    }

    public int getMaxTickDelay() {
        return maxTickDelay;
    }

    public void setMaxTickDelay(int maxTickDelay) {
        this.maxTickDelay = maxTickDelay;
    }

    public int getPopulationCap() {
        return populationCap;
    }

    public void setPopulationCap(int populationCap) {
        this.populationCap = populationCap;
    }

    public int getStructureDensity() {
        return structureDensity;
    }

    public void setStructureDensity(int structureDensity) {
        this.structureDensity = structureDensity;
    }
}
