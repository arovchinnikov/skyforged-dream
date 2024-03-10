package github.arovchinnikov.skyforged_dream.entity;

import github.arovchinnikov.skyforged_dream.entity.block.AnadiumPoisonCloud;
import github.arovchinnikov.skyforged_dream.entity.block.AnadiumPoisonCloudRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;

public class EntityRenderers {
    public static void register() {
        EntityRendererRegistry.register(
            (EntityType<AnadiumPoisonCloud>)EntityTypes.ANADIUM_POISON_CLOUD.entityType(),
            AnadiumPoisonCloudRenderer::new
        );
    }
}
