package dk.mosberg.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import dk.mosberg.entity.RPGVillagerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.text.Text;

public class RPGVillagerEntityRenderer extends MobEntityRenderer<RPGVillagerEntity, VillagerResemblingModel<RPGVillagerEntity>> {
    public RPGVillagerEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new VillagerResemblingModel<>(ctx.getPart(EntityModelLayers.VILLAGER)), 0.5f);
    }

    @Override
    public Identifier getTexture(RPGVillagerEntity entity) {
        return new Identifier("minecraft", "textures/entity/villager/villager.png");
    }

    @Override
    public void render(RPGVillagerEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
        // Render name above head
        if (this.hasLabel(entity)) {
            this.renderLabelIfPresent(entity, Text.of(entity.getPersistentName()), matrices, vertexConsumers, light);
        }
    }
}
