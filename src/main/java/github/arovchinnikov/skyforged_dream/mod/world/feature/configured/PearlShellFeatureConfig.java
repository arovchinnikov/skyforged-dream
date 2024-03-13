package github.arovchinnikov.skyforged_dream.mod.world.feature.configured;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;

public record PearlShellFeatureConfig(float chance) implements FeatureConfig {
    public static final Codec<PearlShellFeatureConfig> CODEC = RecordCodecBuilder.create(
        instance -> instance
            .group(Codec.FLOAT.fieldOf("chance").forGetter(PearlShellFeatureConfig::getChance))
            .apply(instance, PearlShellFeatureConfig::new)
    );

    public float getChance() {
        return chance;
    }
}
