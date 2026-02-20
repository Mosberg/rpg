package dk.mosberg.entity;

/**
 * Villager needs and routines: hunger, rest, social, work, etc.
 */
public class VillagerNeeds {
    private int hunger = 100;
    private int rest = 100;
    private int social = 100;
    private int work = 100;

    // TODO: Add logic for needs decay, fulfillment, and triggers

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
