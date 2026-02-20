package dk.mosberg.entity;

import java.util.Random;

/**
 * Villager personality traits and evolving goals.
 */
public class VillagerPersonality {
    public enum Trait {
        BRAVE, GREEDY, KIND, LAZY, SOCIAL, LONER
    }

    private Trait trait;
    private String goal;

    public VillagerPersonality() {
        // Randomly assign a trait for now
        Trait[] values = Trait.values();
        this.trait = values[new Random().nextInt(values.length)];
        this.goal = "";
    }

    public Trait getTrait() {
        return trait;
    }

    public void setTrait(Trait trait) {
        this.trait = trait;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
