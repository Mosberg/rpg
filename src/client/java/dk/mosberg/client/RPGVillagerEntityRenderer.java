package dk.mosberg.client;

import dk.mosberg.entity.RPGVillagerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.client.render.entity.state.VillagerEntityRenderState;
import net.minecraft.util.Identifier;

public class RPGVillagerEntityRenderer extends
        MobEntityRenderer<RPGVillagerEntity, VillagerEntityRenderState, VillagerResemblingModel> {

    // TODO: Replace with your actual model layer registration key
    public static final EntityModelLayer MODEL_LAYER =
            new EntityModelLayer(Identifier.of("rpg", "villager"), "main");

    public RPGVillagerEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new VillagerResemblingModel(ctx.getPart(MODEL_LAYER)), 0.5f);
    }


    @Override
    public Identifier getTexture(VillagerEntityRenderState state) {
        // You may want to use state/entity to select a texture
        return Identifier.of("minecraft", "textures/entity/villager/villager.png");
    }

    @Override
    public VillagerEntityRenderState createRenderState() {
        // You may want to return a custom state here
        return new VillagerEntityRenderState();
    }
}
