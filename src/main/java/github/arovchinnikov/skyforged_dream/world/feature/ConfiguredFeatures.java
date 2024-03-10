package github.arovchinnikov.skyforged_dream.world.feature;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public enum ConfiguredFeatures {
    DEEPSLATE_ANADIUM_ORE("deepslate_anadium_ore");

    private final Identifier id;
    private RegistryKey<ConfiguredFeature<?, ?>> key;

    ConfiguredFeatures(String name) {
        this.id = new Identifier(SkyforgedDream.MOD_ID, name);
    }

    public static void register() {
        for (ConfiguredFeatures value : values()) {
            value.key = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, value.getId());
        }
    }

    public Identifier getId() {
        return id;
    }

    public RegistryKey<ConfiguredFeature<?, ?>> getKey() {
        return key;
    }
}
