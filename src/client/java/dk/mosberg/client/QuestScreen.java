package dk.mosberg.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class QuestScreen extends Screen {
    public QuestScreen() {
        super(Text.of("Quests"));
    }

    @Override
    protected void init() {
        // Add quest list, progress, etc. (stub)
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseY, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20,
                0xFFFFFF);
        // TODO: Render quest list, progress, etc.
        super.render(context, mouseX, mouseY, delta);
    }
}
