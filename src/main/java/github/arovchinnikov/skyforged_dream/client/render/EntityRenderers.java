package github.arovchinnikov.skyforged_dream.client.render;

import github.arovchinnikov.skyforged_dream.mod.entity.EntityTypes;
import github.arovchinnikov.skyforged_dream.mod.entity.block.AnadiumPoisonCloud;
import github.arovchinnikov.skyforged_dream.client.render.AnadiumPoisonCloudRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;

public class EntityRenderers {
    public static void register() {
        EntityRendererRegistry.register(
            (EntityType<AnadiumPoisonCloud>) EntityTypes.ANADIUM_POISON_CLOUD.entityType(),
            AnadiumPoisonCloudRenderer::new
        );
    }
}
