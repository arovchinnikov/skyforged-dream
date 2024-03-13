package github.arovchinnikov.skyforged_dream.client;

import github.arovchinnikov.skyforged_dream.client.render.EntityRenderers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SkyforgedDreamClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRenderers.register();
    }
}
