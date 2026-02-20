package dk.mosberg.entity;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class RPGVillagerEntityInteraction {
    public static void register() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!(entity instanceof RPGVillagerEntity)) return ActionResult.PASS;
            if (world.isClient()) return ActionResult.PASS;
            if (hand != Hand.MAIN_HAND) return ActionResult.PASS;
            if (!player.isSneaking()) return ActionResult.PASS;
            // Send villager info to client
            RPGVillagerEntity villager = (RPGVillagerEntity) entity;
            PacketByteBuf buf = new PacketByteBuf(io.netty.buffer.Unpooled.buffer());
            buf.writeString(villager.getPersistentName());
            buf.writeString("TODO: Profession");
            buf.writeInt(50); // TODO: Reputation
            buf.writeString("TODO: Needs");
            buf.writeString("TODO: Relationships");
            buf.writeString("TODO: Quests");
            ServerPlayNetworking.send((ServerPlayerEntity) player, new Identifier("rpg", "villager_info"), buf);
            return ActionResult.SUCCESS;
        });
    }
}
