package dk.mosberg.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class VillageManagerScreen extends Screen {
    private final String villageData;

    public VillageManagerScreen() {
        this("");
    }
    public VillageManagerScreen(String villageData) {
        super(Text.of("Village Manager"));
        this.villageData = villageData;
    }

    @Override
    protected void init() {
        // Add buttons/widgets for village management (stub)
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        context.drawCenteredText(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        // TODO: Render village stats, controls, etc.
        super.render(context, mouseX, mouseY, delta);
    }
}
