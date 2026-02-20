package dk.mosberg.profession;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry for RPG professions, supporting data-driven extension.
 */
public class ProfessionRegistry {
    private static final Map<String, ProfessionType> REGISTRY = new HashMap<>();

    static {
        // Register default professions
        for (ProfessionType type : ProfessionType.values()) {
            REGISTRY.put(type.name().toLowerCase(), type);
        }
    }

    public static void register(String id, ProfessionType type) {
        REGISTRY.put(id, type);
    }

    public static ProfessionType get(String id) {
        return REGISTRY.get(id);
    }

    public static Map<String, ProfessionType> getAll() {
        return REGISTRY;
    }
}
