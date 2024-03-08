package github.arovchinnikov.skyforged_dream.world.biome;

import github.arovchinnikov.skyforged_dream.world.feature.Features;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;

public class BiomeUpdates {
    public static void updateFeatures() {
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.VEGETAL_DECORATION,
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Features.PEARL_SHELL.getId())
        );
    }
}
