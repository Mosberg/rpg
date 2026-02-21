package dk.mosberg.admin;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

/**
 * Handles registration and logic for the Village Manager block and admin UI.
 */
public class AdminUI {
    public static Block VILLAGE_MANAGER_BLOCK;

    public static void register() {
        // Register the Village Manager block
        VILLAGE_MANAGER_BLOCK = new VillageManagerBlock(AbstractBlock.Settings.create()
                // .blockId("rpg:village_manager") // Uncomment if available in mappings
                .strength(4.0f));
        Registry.register(Registries.BLOCK,
                net.minecraft.util.Identifier.of("rpg", "village_manager"), VILLAGE_MANAGER_BLOCK);
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!world.isClient()) {
                if (world.getBlockState(hitResult.getBlockPos()).getBlock() == VILLAGE_MANAGER_BLOCK
                        && hand == Hand.MAIN_HAND) {
                    // Send village data to client (stub)
                    dk.mosberg.network.VillageManagerDataPayload payload =
                            new dk.mosberg.network.VillageManagerDataPayload("TODO: Village Data");
                    ServerPlayNetworking.send((ServerPlayerEntity) player, payload);
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        });
    }
}
