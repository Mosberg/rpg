package dk.mosberg.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class RPGClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		// Register handler for villager info screen
		ClientPlayNetworking.registerGlobalReceiver(
			new net.minecraft.util.Identifier("rpg:villager_info"),
			(client, handler, buf, responseSender) -> {
				String name = buf.readUtf();
				String profession = buf.readUtf();
				int reputation = buf.readVarInt();
				String needs = buf.readUtf();
				String relationships = buf.readUtf();
				String quests = buf.readUtf();
				client.execute(() -> {
					MinecraftClient.getInstance().setScreen(
						new VillagerInfoScreen(name, profession, reputation, needs, relationships, quests)
					);
				});
			}
		);
		ClientPlayNetworking.registerGlobalReceiver(
			new net.minecraft.util.Identifier("rpg:village_manager_data"),
			(client, handler, buf, responseSender) -> {
				String data = buf.readUtf();
				client.execute(() -> {
					MinecraftClient.getInstance().setScreen(new VillageManagerScreen(data));
				});
			}
		);
		HudRenderCallback.EVENT.register(new VillageNameHud());
		HudRenderCallback.EVENT.register(new ReputationHud());
	}
}