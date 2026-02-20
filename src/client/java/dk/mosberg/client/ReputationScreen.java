package dk.mosberg.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ReputationScreen extends Screen {
    public ReputationScreen() {
        super(Text.of("Reputation"));
    }

    @Override
    protected void init() {
        // Add reputation info (stub)
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseY, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20,
                0xFFFFFF);
        // TODO: Render reputation info
        super.render(context, mouseX, mouseY, delta);
    }
}
