package github.arovchinnikov.skyforged_dream.util.datagen.bootstrap;

import github.arovchinnikov.skyforged_dream.util.datagen.helper.OrePlacement;
import github.arovchinnikov.skyforged_dream.common.feature.ConfiguredFeatures;
import github.arovchinnikov.skyforged_dream.common.feature.PlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class PlacedFeaturesData {
    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(
            context,
            PlacedFeatures.DEEPSLATE_ANADIUM_ORE.getKey(),
            configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeatures.DEEPSLATE_ANADIUM_ORE.getKey()),
            OrePlacement.modifiersWithCount(
                8,
                HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(20))
            )
        );
    }

    private static void register(
        Registerable<PlacedFeature> context,
        RegistryKey<PlacedFeature> key,
        RegistryEntry<ConfiguredFeature<?, ?>> configuration,
        List<PlacementModifier> modifiers
    ) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
