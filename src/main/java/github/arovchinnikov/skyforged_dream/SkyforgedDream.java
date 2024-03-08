package github.arovchinnikov.skyforged_dream;

import github.arovchinnikov.skyforged_dream.block.Blocks;
import github.arovchinnikov.skyforged_dream.item.ItemGroups;
import github.arovchinnikov.skyforged_dream.item.Items;
import github.arovchinnikov.skyforged_dream.world.biome.BiomeUpdates;
import github.arovchinnikov.skyforged_dream.world.feature.Features;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkyforgedDream implements ModInitializer {
	public static final String MOD_ID = "skyforged_dream";
	public static final Logger LOGGER = LoggerFactory.getLogger("skyforged_dream");

	@Override
	public void onInitialize() {
		Blocks.register();
		Items.register();
		ItemGroups.register();

		Features.register();

		BiomeUpdates.updateFeatures();
	}
}
