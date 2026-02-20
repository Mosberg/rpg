package dk.mosberg.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class EventScreen extends Screen {
    public EventScreen() {
        super(Text.of("Events"));
    }

    @Override
    protected void init() {
        // Add event info (stub)
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseY, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20,
                0xFFFFFF);
        // TODO: Render event info
        super.render(context, mouseX, mouseY, delta);
    }
}
