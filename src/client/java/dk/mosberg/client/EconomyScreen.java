package dk.mosberg.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class EconomyScreen extends Screen {
    public EconomyScreen() {
        super(Text.of("Economy"));
    }

    @Override
    protected void init() {
        // Add economy info (stub)
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        context.drawCenteredText(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        // TODO: Render economy info
        super.render(context, mouseX, mouseY, delta);
    }
}
