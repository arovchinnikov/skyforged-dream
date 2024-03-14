package github.arovchinnikov.skyforged_dream.util.datagen.bootstrap;

import github.arovchinnikov.skyforged_dream.common.block.Blocks;
import github.arovchinnikov.skyforged_dream.common.feature.ConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ConfiguredFeaturesData {
    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest deepslateReplace = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldAnadium = List.of(OreFeatureConfig.createTarget(
            deepslateReplace, Blocks.DEEPSLATE_ANADIUM_ORE.block().getDefaultState()
        ));

        register(
            context,
            ConfiguredFeatures.DEEPSLATE_ANADIUM_ORE.getKey(),
            new OreFeatureConfig(overworldAnadium, 6)
        );
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
        Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key,
        FC configuration
    ) {
        context.register(key, new ConfiguredFeature<>((F) Feature.ORE, configuration));
    }
}
