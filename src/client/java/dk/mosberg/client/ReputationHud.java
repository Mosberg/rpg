package dk.mosberg.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public class ReputationHud implements HudRenderCallback {
    private static int lastReputationChange = 0;
    private static long lastChangeTime = 0;
    private static final int FADE_TIME = 40; // ticks

    public static void showReputationChange(int amount) {
        lastReputationChange = amount;
        lastChangeTime = System.currentTimeMillis();
    }

    @Override
    public void onHudRender(DrawContext context, RenderTickCounter tickCounter) {
        if (lastReputationChange == 0) return;
        long elapsed = (System.currentTimeMillis() - lastChangeTime) / 50;
        if (elapsed > FADE_TIME) return;
        int alpha = 255 - (int)(255 * (float)elapsed / FADE_TIME);
        int color = (lastReputationChange > 0 ? 0x00FF00 : 0xFF0000) | (alpha << 24);
        String text = (lastReputationChange > 0 ? "+" : "") + lastReputationChange + " Reputation";
        MinecraftClient client = MinecraftClient.getInstance();
        int width = client.getWindow().getScaledWidth();
        int y = 60;
        context.drawText(client.textRenderer, text, (width - client.textRenderer.getWidth(text)) / 2, y, color, true);
    }
}
