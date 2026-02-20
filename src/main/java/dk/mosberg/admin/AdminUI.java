package dk.mosberg.admin;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

/**
 * Handles registration and logic for the Village Manager block and admin UI.
 */
public class AdminUI {
    public static Block VILLAGE_MANAGER_BLOCK;

    public static void register() {
        // Register the Village Manager block
        VILLAGE_MANAGER_BLOCK = new Block(AbstractBlock.Settings.create().strength(4.0f));
        Registry.register(Registries.BLOCK, Identifier.of("rpg", "village_manager"),
                VILLAGE_MANAGER_BLOCK);
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!world.isClient()) {
                if (world.getBlockState(hitResult.getBlockPos()).getBlock() == VILLAGE_MANAGER_BLOCK
                        && hand == Hand.MAIN_HAND) {
                    // Send village data to client (stub)
                    PacketByteBuf buf = new PacketByteBuf(io.netty.buffer.Unpooled.buffer());
                    buf.writeString("TODO: Village Data");
                    ServerPlayNetworking.send((ServerPlayerEntity) player,
                            Identifier.of("rpg", "village_manager_data"), buf);
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        });
    }
}
