package github.arovchinnikov.skyforged_dream.common.feature;

import github.arovchinnikov.skyforged_dream.util.ModId;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

public enum PlacedFeatures {
    DEEPSLATE_ANADIUM_ORE("deepslate_anadium_ore");

    private final Identifier id;
    private RegistryKey<PlacedFeature> key;

    PlacedFeatures(String name) {
        this.id = ModId.get(name);
    }

    public static void register() {
        for (PlacedFeatures value : values()) {
            value.key = RegistryKey.of(RegistryKeys.PLACED_FEATURE, value.getId());
        }
    }

    public Identifier getId() {
        return id;
    }

    public RegistryKey<PlacedFeature> getKey() {
        return key;
    }
}
