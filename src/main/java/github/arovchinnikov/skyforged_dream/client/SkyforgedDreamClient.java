package github.arovchinnikov.skyforged_dream.client;

import github.arovchinnikov.skyforged_dream.client.render.EntityRenderers;
import github.arovchinnikov.skyforged_dream.client.render.HamsterModel;
import github.arovchinnikov.skyforged_dream.client.render.HamsterRenderer;
import github.arovchinnikov.skyforged_dream.client.render.ModelLayers;
import github.arovchinnikov.skyforged_dream.common.entity.EntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class SkyforgedDreamClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRenderers.register();

        EntityRendererRegistry.register(EntityTypes.HAMSTER, HamsterRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModelLayers.HAMSTER, HamsterModel::getTexturedModelData);
    }
}
