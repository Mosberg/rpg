# Copilot Instructions for Village & Villager RPG Expansion

## Project Overview

- This is a Minecraft 1.21.11 mod for Fabric 0.141.3+1.21.11 using yarn-mappings 1.21.11+build.4 and split-sources, focused on overhauling villages and villagers with RPG and simulation features.
- The codebase is modular, with split `main` and `client` sources (see `src/main/java` and `src/client/java`).
- Major systems: worldgen, villager AI, professions, economy, quests, reputation, defense, and customization.
- Data-driven: JSON files (in `assets/rpg/` and `config/`) define professions, trades, quests, and structures.

## Build & Development

- **Build:** Use `./gradlew build` (or `gradlew.bat build` on Windows).
- **Run Client:** `./gradlew runClient` (or via VS Code/IDE run configs).
- **Run Server:** `./gradlew runServer`
- **Test:** `./gradlew test` (JUnit 6, see `build.gradle` for config).
- Java 21 is required (see `gradle.properties`).
- Mod metadata is templated via `gradle.properties` and expanded into `fabric.mod.json` and config files.
- The `validateModMetadata` Gradle task ensures all required mod properties are set before build.

## Key Conventions & Patterns

- **Entrypoints:**
  - Main: `dk.mosberg.RPG`
  - Client: `dk.mosberg.client.RPGClient`
  - Mod Menu: `dk.mosberg.client.modmenu.RPGModMenu`
- **Source Sets:**
  - `main` is for shared/server logic; `client` is for client-only code (rendering, screens, etc.).
  - `main` runtime classpath includes `client` output for unified access.
- **Data/Assets:**
  - Place mod assets and JSON data in `src/main/resources/assets/rpg/`.
  - Config templates are in `src/main/resources/config/` and expanded at build.
- **Dependencies:**
  - Uses Fabric API, Mod Menu, Cloth Config, Gson, SLF4J, and JUnit 6 (see `build.gradle`).
  - Optional dependencies are declared in `fabric.mod.json` and handled via Gradle.
- **Testing:**
  - JUnit 6 is used for tests; test sources can access client code due to classpath setup.
- **IDE Support:**
  - The project is configured for IntelliJ IDEA and VS Code (see `build.gradle` and `.vscode/`).

## Integration & Extensibility

- All major systems are designed to be data-driven and extensible via JSON/datapacks.
- Other mods can patch into events, trade tables, and AI goals.
- Mod Menu and Cloth Config are used for in-game configuration.

## References

- See `README.md` for the full feature roadmap and design vision.
- See `.github/remote-index.md` for API docs and modding guides.
- See `.github/remote-index-mods.md` for reference mod repositories.

---

**When contributing code or using Copilot, follow the above conventions and reference the listed files for examples of project structure and patterns.**
