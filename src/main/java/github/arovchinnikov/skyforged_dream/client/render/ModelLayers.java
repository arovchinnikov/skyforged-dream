package github.arovchinnikov.skyforged_dream.client.render;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModelLayers {
    public static final EntityModelLayer HAMSTER =
        new EntityModelLayer(new Identifier(SkyforgedDream.MOD_ID, "hamster"), "main");
}
