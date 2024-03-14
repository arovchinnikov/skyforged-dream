package github.arovchinnikov.skyforged_dream.client.render;

import github.arovchinnikov.skyforged_dream.common.entity.EntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class EntityRenderers {
    public static void register() {
        EntityRendererRegistry.register(
            EntityTypes.ANADIUM_POISON_CLOUD,
            AnadiumPoisonCloudRenderer::new
        );
    }
}
