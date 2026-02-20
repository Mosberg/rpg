package dk.mosberg.defense;

/**
 * Handles alarm and defense upgrades (towers, bells, gates).
 */
public class DefenseUpgrades {
    private boolean guardTowers = false;
    private boolean alarmBells = false;
    private boolean reinforcedGates = false;

    public void setGuardTowers(boolean enabled) {
        guardTowers = enabled;
    }

    public boolean hasGuardTowers() {
        return guardTowers;
    }

    public void setAlarmBells(boolean enabled) {
        alarmBells = enabled;
    }

    public boolean hasAlarmBells() {
        return alarmBells;
    }

    public void setReinforcedGates(boolean enabled) {
        reinforcedGates = enabled;
    }

    public boolean hasReinforcedGates() {
        return reinforcedGates;
    }
}
