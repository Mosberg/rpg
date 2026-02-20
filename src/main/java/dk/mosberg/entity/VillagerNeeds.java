package dk.mosberg.entity;

/**
 * Villager needs and routines: hunger, rest, social, work, etc.
 */
public class VillagerNeeds {
    private int hunger = 100;
    private int rest = 100;
    private int social = 100;
    private int work = 100;

    // Logic for needs decay, fulfillment, and triggers
    public void tick() {
        hunger = Math.max(0, hunger - 1);
        rest = Math.max(0, rest - 1);
        social = Math.max(0, social - 1);
        work = Math.max(0, work - 1);
    }

    public void fulfillHunger(int amount) {
        hunger = Math.min(100, hunger + amount);
    }

    public void fulfillRest(int amount) {
        rest = Math.min(100, rest + amount);
    }

    public void fulfillSocial(int amount) {
        social = Math.min(100, social + amount);
    }

    public void fulfillWork(int amount) {
        work = Math.min(100, work + amount);
    }

    public boolean isHungry() {
        return hunger < 20;
    }

    public boolean isTired() {
        return rest < 20;
    }

    public boolean isLonely() {
        return social < 20;
    }

    public boolean needsWork() {
        return work < 20;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public int getWork() {
        return work;
    }

    public void setWork(int work) {
        this.work = work;
    }
}
