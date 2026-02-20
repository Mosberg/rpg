package dk.mosberg.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;


public class RPGClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register handler for villager info screen
        ClientPlayNetworking.registerGlobalReceiver(dk.mosberg.network.VillagerInfoPayload.ID,
                (payload, context) -> {
                    context.client().execute(() -> {
                        MinecraftClient.getInstance()
                                .setScreen(new VillagerInfoScreen(payload.name, payload.profession,
                                        payload.reputation, payload.needs, payload.relationships,
                                        payload.quests));
                    });
                });
        ClientPlayNetworking.registerGlobalReceiver(dk.mosberg.network.VillageManagerDataPayload.ID,
                (payload, context) -> {
                    context.client().execute(() -> {
                        MinecraftClient.getInstance()
                                .setScreen(new VillageManagerScreen(payload.data));
                    });
                });
        // TODO: Replace HudRenderCallback with HudElementRegistry for overlays
        // HudElementRegistry.addLast(Identifier.of("rpg", "village_name_hud"), new
        // VillageNameHudElement());
        // HudElementRegistry.addLast(Identifier.of("rpg", "reputation_hud"), new
        // ReputationHudElement());
    }
}
