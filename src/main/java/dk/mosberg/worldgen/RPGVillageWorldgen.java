package dk.mosberg.worldgen;

/**
 * Main entry for RPG village world generation overhaul. Handles registration of new village types,
 * templates, and structure logic.
 */
public class RPGVillageWorldgen {
    public static void register() {
        // Register new village types
        String[] types = {"frontier", "harbor", "mountain", "forest", "nomad"};
        for (String type : types) {
            VillageTemplateRegistry.registerVillageType(type);
        }

        // Register structure templates and pools for each type
        for (String type : types) {
            VillageTemplateRegistry.registerStructurePool(type);
        }

        // Register village core/manager block structure
        VillageTemplateRegistry.registerManagerBlockStructure();

        // Hook into biome placement logic
        VillageTemplateRegistry.hookBiomePlacement();
    }
}
