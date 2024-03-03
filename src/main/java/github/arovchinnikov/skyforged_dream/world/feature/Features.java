package github.arovchinnikov.skyforged_dream.world.feature;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.world.feature.configured.SeashellFeature;
import github.arovchinnikov.skyforged_dream.world.feature.configured.SeashellFeatureConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public enum Features {
    OCEAN_SEASHELL("seashell_feature");

    private final Identifier id;

    Features(String name) {
        this.id = new Identifier(SkyforgedDream.MOD_ID, name);
    }

    public static void register() {
        for (Features value : values()) {
            Registry.register(Registries.FEATURE, value.id, new SeashellFeature(SeashellFeatureConfig.CODEC));
        }
    }

    public Identifier getId() {
        return id;
    }
}
