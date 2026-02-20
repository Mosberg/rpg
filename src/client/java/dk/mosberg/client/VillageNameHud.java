package dk.mosberg.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class VillageNameHud implements HudRenderCallback {
    private static String currentVillageName = null;
    private static long lastEnterTime = 0;
    private static final int FADE_TIME = 40; // ticks

    public static void setVillageName(String name) {
        currentVillageName = name;
        lastEnterTime = System.currentTimeMillis();
    }

    @Override
    public void onHudRender(DrawContext context, RenderTickCounter tickCounter) {
        if (currentVillageName == null) return;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;
        long elapsed = (System.currentTimeMillis() - lastEnterTime) / 50;
        if (elapsed > FADE_TIME) return;
        int alpha = 255 - (int)(255 * (float)elapsed / FADE_TIME);
        int color = (alpha << 24) | 0xFFFFFF;
        int width = client.getWindow().getScaledWidth();
        int y = 30;
        context.drawText(client.textRenderer, currentVillageName, (width - client.textRenderer.getWidth(currentVillageName)) / 2, y, color, true);
    }
}
