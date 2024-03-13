package github.arovchinnikov.skyforged_dream.mod;

import github.arovchinnikov.skyforged_dream.mod.block.Blocks;
import github.arovchinnikov.skyforged_dream.mod.effect.StatusEffects;
import github.arovchinnikov.skyforged_dream.mod.entity.EntityTypes;
import github.arovchinnikov.skyforged_dream.mod.item.ItemGroups;
import github.arovchinnikov.skyforged_dream.mod.item.Items;
import github.arovchinnikov.skyforged_dream.mod.world.biome.BiomeUpdates;
import github.arovchinnikov.skyforged_dream.mod.world.feature.ConfiguredFeatures;
import github.arovchinnikov.skyforged_dream.mod.world.feature.Features;
import github.arovchinnikov.skyforged_dream.mod.world.feature.PlacedFeatures;
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
