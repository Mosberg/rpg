package dk.mosberg.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.World;

import java.util.UUID;

/**
 * Base class for RPG Villager with advanced AI, memory, and needs.
 */
public class RPGVillagerEntity extends PathAwareEntity {
    // Stub goal classes for demonstration
    public static class RoutineGoal extends net.minecraft.entity.ai.goal.Goal {
        private final RPGVillagerEntity villager;

        public RoutineGoal(RPGVillagerEntity villager) {
            this.villager = villager;
        }

        @Override
        public boolean canStart() {
            return false;
        }

        @Override
        public void start() {}

        @Override
        public void tick() {}
    }
    public static class SocialGoal extends net.minecraft.entity.ai.goal.Goal {
        private final RPGVillagerEntity villager;

        public SocialGoal(RPGVillagerEntity villager) {
            this.villager = villager;
        }

        @Override
        public boolean canStart() {
            return false;
        }

        @Override
        public void start() {}

        @Override
        public void tick() {}
    }
    public static class NeedsGoal extends net.minecraft.entity.ai.goal.Goal {
        private final RPGVillagerEntity villager;

        public NeedsGoal(RPGVillagerEntity villager) {
            this.villager = villager;
        }

        @Override
        public boolean canStart() {
            return false;
        }

        @Override
        public void start() {}

        @Override
        public void tick() {}
    }

    private static final String NBT_NAME_KEY = "RPGVillagerName";

    private final VillagerMemory memory = new VillagerMemory();
    private final VillagerNeeds needs = new VillagerNeeds();
    private final VillagerRelationships relationships = new VillagerRelationships();
    private final VillagerPersonality personality = new VillagerPersonality();

    private String persistentName;

    public static final EntityType<RPGVillagerEntity> TYPE = Registry.register(
        Registries.ENTITY_TYPE,
        new Identifier("rpg", "villager"),
        EntityType.Builder.create(RPGVillagerEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6F, 1.95F)
            .build()
    );

    protected RPGVillagerEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        // Custom AI goals for routines, social, and needs
        this.goalSelector.add(1, new RoutineGoal(this));
        this.goalSelector.add(2, new SocialGoal(this));
        this.goalSelector.add(3, new NeedsGoal(this));
    }

    public void writeData(NbtCompound nbt) {
        super.writeData(nbt);
        if (persistentName != null) nbt.putString(NBT_NAME_KEY, persistentName);
    }

    public void readData(NbtCompound nbt) {
        super.readData(nbt);
        persistentName = nbt.getString(NBT_NAME_KEY).orElse(null);
    }

    public String getPersistentName() {
        if (persistentName == null) {
            persistentName = generateRandomName();
        }
        return persistentName;
    }

    public void setPersistentName(String name) {
        this.persistentName = name;
        this.setCustomName(Text.of(name));
    }

    private String generateRandomName() {
        // Simple random name generator (expand as needed)
        String[] names = {"Asta", "Bjorn", "Dagny", "Einar", "Freja", "Gunnar", "Inga", "Leif", "Sigrid", "Torben"};
        return names[Math.abs(UUID.randomUUID().hashCode()) % names.length];
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
