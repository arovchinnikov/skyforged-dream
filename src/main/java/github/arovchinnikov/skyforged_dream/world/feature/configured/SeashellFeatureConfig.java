package github.arovchinnikov.skyforged_dream.world.feature.configured;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;

public record SeashellFeatureConfig(float chance) implements FeatureConfig {
    public static final Codec<SeashellFeatureConfig> CODEC = RecordCodecBuilder.create(
        instance -> instance
            .group(Codec.FLOAT.fieldOf("chance").forGetter(SeashellFeatureConfig::getChance))
            .apply(instance, SeashellFeatureConfig::new)
    );

    public float getChance() {
        return chance;
    }
}
