package dk.mosberg.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;


public class RPGClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        // Register handler for villager info screen
        ClientPlayNetworking.registerGlobalReceiver(new Identifier("rpg", "villager_info"),
                (client, handler, buf, responseSender) -> {
                    String name = buf.readString();
                    String profession = buf.readString();
                    int reputation = buf.readVarInt();
                    String needs = buf.readString();
                    String relationships = buf.readString();
                    String quests = buf.readString();
                    client.execute(() -> {
                        MinecraftClient.getInstance().setScreen(new VillagerInfoScreen(name,
                                profession, reputation, needs, relationships, quests));
                    });
                });
        ClientPlayNetworking.registerGlobalReceiver(new Identifier("rpg", "village_manager_data"),
                (client, handler, buf, responseSender) -> {
                    String data = buf.readString();
                    client.execute(() -> {
                        MinecraftClient.getInstance().setScreen(new VillageManagerScreen(data));
                    });
                });
        HudElementRegistry.RENDER.register(new VillageNameHud());
        HudElementRegistry.RENDER.register(new ReputationHud());
    }
}
