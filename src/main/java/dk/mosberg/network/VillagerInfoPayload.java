package dk.mosberg.network;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.CustomPayload;

public class VillagerInfoPayload implements CustomPayload {
    public static final Id<VillagerInfoPayload> ID =
            new Id<>(net.minecraft.util.Identifier.of("rpg", "villager_info"));

    public final String name;
    public final String profession;
    public final int reputation;
    public final String needs;
    public final String relationships;
    public final String quests;

    public VillagerInfoPayload(String name, String profession, int reputation, String needs,
            String relationships, String quests) {
        this.name = name;
        this.profession = profession;
        this.reputation = reputation;
        this.needs = needs;
        this.relationships = relationships;
        this.quests = quests;
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }

    public void write(PacketByteBuf buf) {
        buf.writeString(name);
        buf.writeString(profession);
        buf.writeInt(reputation);
        buf.writeString(needs);
        buf.writeString(relationships);
        buf.writeString(quests);
    }

    public static VillagerInfoPayload read(PacketByteBuf buf) {
        return new VillagerInfoPayload(buf.readString(), buf.readString(), buf.readInt(),
                buf.readString(), buf.readString(), buf.readString());
    }
}
