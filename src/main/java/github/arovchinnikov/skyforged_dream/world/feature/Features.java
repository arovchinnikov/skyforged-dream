package github.arovchinnikov.skyforged_dream.world.feature;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.world.feature.configured.SeashellFeature;
import github.arovchinnikov.skyforged_dream.world.feature.configured.SeashellFeatureConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.function.Supplier;

public enum Features {
    PEARL_SHELL("pearl_shell_feature", () -> new SeashellFeature(SeashellFeatureConfig.CODEC));

    private final Identifier id;
    private final Feature<? extends FeatureConfig> feature;

    Features(String name, Supplier<Feature<? extends FeatureConfig>> featureSupplier) {
        this.id = new Identifier(SkyforgedDream.MOD_ID, name);
        this.feature = featureSupplier.get();
    }

    public static void register() {
        for (Features value : values()) {
            Registry.register(Registries.FEATURE, value.getId(), value.feature);
        }
    }

    public Identifier getId() {
        return id;
    }
}
