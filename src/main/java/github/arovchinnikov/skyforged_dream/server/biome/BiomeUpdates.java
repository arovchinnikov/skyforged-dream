package github.arovchinnikov.skyforged_dream.server.biome;

import github.arovchinnikov.skyforged_dream.common.feature.Features;
import github.arovchinnikov.skyforged_dream.common.feature.PlacedFeatures;
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

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES, PlacedFeatures.DEEPSLATE_ANADIUM_ORE.getKey());
    }
}
