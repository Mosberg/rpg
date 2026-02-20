package dk.mosberg.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

/**
 * Base class for RPG Villager with advanced AI, memory, and needs.
 */
public class RPGVillagerEntity extends PathAwareEntity {
    private final VillagerMemory memory = new VillagerMemory();
    private final VillagerNeeds needs = new VillagerNeeds();
    private final VillagerRelationships relationships = new VillagerRelationships();
    private final VillagerPersonality personality = new VillagerPersonality();

    protected RPGVillagerEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        // TODO: Add custom AI goals for routines, social, and needs
    }

    public VillagerMemory getMemory() {
        return memory;
    }

    public VillagerNeeds getNeeds() {
        return needs;
    }

    public VillagerRelationships getRelationships() {
        return relationships;
    }

    public VillagerPersonality getPersonality() {
        return personality;
    }
}
