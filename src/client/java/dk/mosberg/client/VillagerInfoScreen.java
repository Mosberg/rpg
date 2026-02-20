package dk.mosberg.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import dk.mosberg.entity.RPGVillagerEntity;

public class VillagerInfoScreen extends Screen {
    private final String name;
    private final String profession;
    private final int reputation;
    private final String needs;
    private final String relationships;
    private final String quests;

    public VillagerInfoScreen(String name, String profession, int reputation, String needs, String relationships, String quests) {
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
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        drawTextWithShadow(matrices, this.textRenderer, "Name: " + name, 40, 50, 0xFFFFFF);
        drawTextWithShadow(matrices, this.textRenderer, "Profession: " + profession, 40, 70, 0xFFFFFF);
        drawTextWithShadow(matrices, this.textRenderer, "Reputation: " + reputation, 40, 90, 0xFFFFFF);
        drawTextWithShadow(matrices, this.textRenderer, "Needs: " + needs, 40, 110, 0xFFFFFF);
        drawTextWithShadow(matrices, this.textRenderer, "Relationships: " + relationships, 40, 130, 0xFFFFFF);
        drawTextWithShadow(matrices, this.textRenderer, "Quests: " + quests, 40, 150, 0xFFFFFF);
        super.render(matrices, mouseX, mouseY, delta);
    }
}

