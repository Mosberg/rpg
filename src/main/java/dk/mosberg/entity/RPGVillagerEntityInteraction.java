package dk.mosberg.entity;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class RPGVillagerEntityInteraction {
    @SuppressWarnings("unchecked")
    public static void register() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!(entity instanceof RPGVillagerEntity))
                return ActionResult.PASS;
            if (world.isClient())
                return ActionResult.PASS;
            if (hand != Hand.MAIN_HAND)
                return ActionResult.PASS;
            if (!player.isSneaking())
                return ActionResult.PASS;
            // Send villager info to client
            RPGVillagerEntity villager = (RPGVillagerEntity) entity;
            dk.mosberg.network.VillagerInfoPayload payload =
                    new dk.mosberg.network.VillagerInfoPayload(villager.getPersistentName(),
                            "TODO: Profession", 50, // TODO: Reputation
                            "TODO: Needs", "TODO: Relationships", "TODO: Quests");
            ServerPlayNetworking.send((ServerPlayerEntity) player, payload);
            return ActionResult.SUCCESS;
        });
    }
}
