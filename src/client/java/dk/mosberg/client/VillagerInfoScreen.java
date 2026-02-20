package dk.mosberg.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class VillagerInfoScreen extends Screen {
    private final String name;
    private final String profession;
    private final int reputation;
    private final String needs;
    private final String relationships;
    private final String quests;

    public VillagerInfoScreen(String name, String profession, int reputation, String needs,
            String relationships, String quests) {
        super(Text.of("Villager Info"));
        this.name = name;
        this.profession = profession;
        this.reputation = reputation;
        this.needs = needs;
        this.relationships = relationships;
        this.quests = quests;
    }

    @Override
    protected void init() {
        // Add buttons/widgets if needed
    }

    @Override
    public void render(DrawContext matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices, mouseX, mouseY, delta);
        matrices.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20,
                0xFFFFFF);
        matrices.drawTextWithShadow(this.textRenderer, Text.of("Name: " + name), 40, 50, 0xFFFFFF);
        matrices.drawTextWithShadow(this.textRenderer, Text.of("Profession: " + profession), 40, 70,
                0xFFFFFF);
        matrices.drawTextWithShadow(this.textRenderer, Text.of("Reputation: " + reputation), 40, 90,
                0xFFFFFF);
        matrices.drawTextWithShadow(this.textRenderer, Text.of("Needs: " + needs), 40, 110,
                0xFFFFFF);
        matrices.drawTextWithShadow(this.textRenderer, Text.of("Relationships: " + relationships),
                40, 130, 0xFFFFFF);
        matrices.drawTextWithShadow(this.textRenderer, Text.of("Quests: " + quests), 40, 150,
                0xFFFFFF);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
