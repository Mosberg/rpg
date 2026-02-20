package dk.mosberg.network;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public class VillageManagerDataPayload implements CustomPayload {
    public static final Id<VillageManagerDataPayload> ID =
            new Id<>(Identifier.of("rpg", "village_manager_data"));

    public final String data;

    public VillageManagerDataPayload(String data) {
        this.data = data;
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }

    public void write(PacketByteBuf buf) {
        buf.writeString(data);
    }

    public static VillageManagerDataPayload read(PacketByteBuf buf) {
        return new VillageManagerDataPayload(buf.readString());
    }
}
