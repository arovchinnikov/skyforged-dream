package github.arovchinnikov.skyforged_dream;

import com.mojang.serialization.Codec;
import github.arovchinnikov.skyforged_dream.block.Blocks;
import github.arovchinnikov.skyforged_dream.effect.StatusEffects;
import github.arovchinnikov.skyforged_dream.entity.EntityRenderers;
import github.arovchinnikov.skyforged_dream.entity.EntityTypes;
import github.arovchinnikov.skyforged_dream.item.ItemGroups;
import github.arovchinnikov.skyforged_dream.item.Items;
import github.arovchinnikov.skyforged_dream.world.biome.BiomeUpdates;
import github.arovchinnikov.skyforged_dream.world.feature.ConfiguredFeatures;
import github.arovchinnikov.skyforged_dream.world.feature.Features;
import github.arovchinnikov.skyforged_dream.world.feature.PlacedFeatures;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkyforgedDream implements ModInitializer {
	public static final String MOD_ID = "skyforged_dream";
	public static final Logger LOGGER = LoggerFactory.getLogger("skyforged_dream");

	@Override
	public void onInitialize() {
		StatusEffects.register();
		Blocks.register();
		Items.register();
		ItemGroups.register();
		EntityTypes.register();

		Features.register();
		PlacedFeatures.register();
		ConfiguredFeatures.register();

		BiomeUpdates.updateFeatures();
	}
}
