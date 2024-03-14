package github.arovchinnikov.skyforged_dream.client.render;

import github.arovchinnikov.skyforged_dream.common.entity.ambient.AnadiumPoisonCloud;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class AnadiumPoisonCloudRenderer extends EntityRenderer<AnadiumPoisonCloud> {
    public AnadiumPoisonCloudRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(AnadiumPoisonCloud entity) {
        return null;
    }

    @Override
    public void render(
        AnadiumPoisonCloud entity,
        float yaw,
        float tickDelta,
        MatrixStack matrices,
        VertexConsumerProvider vertexConsumers,
        int light
    ) {

    }
}
