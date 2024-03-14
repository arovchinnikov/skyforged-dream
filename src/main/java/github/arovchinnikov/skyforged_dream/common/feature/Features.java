package github.arovchinnikov.skyforged_dream.common.feature;

import github.arovchinnikov.skyforged_dream.common.feature.features.PearlShellFeature;
import github.arovchinnikov.skyforged_dream.common.feature.features.PearlShellFeatureConfig;
import github.arovchinnikov.skyforged_dream.util.ModId;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.function.Supplier;

public enum Features {
    PEARL_SHELL("pearl_shell_feature", () -> new PearlShellFeature(PearlShellFeatureConfig.CODEC));

    private final Identifier id;
    private final Feature<? extends FeatureConfig> feature;

    Features(String name, Supplier<Feature<? extends FeatureConfig>> featureSupplier) {
        this.id = ModId.get(name);
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
