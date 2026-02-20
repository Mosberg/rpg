package dk.mosberg.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class VillageStatsScreen extends Screen {
    public VillageStatsScreen() {
        super(Text.of("Village Stats"));
    }

    @Override
    protected void init() {
        // Add stats info (stub)
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseY, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20,
                0xFFFFFF);
        // TODO: Render stats info
        super.render(context, mouseX, mouseY, delta);
    }
}
