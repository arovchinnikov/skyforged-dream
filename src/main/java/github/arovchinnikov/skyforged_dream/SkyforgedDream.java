package github.arovchinnikov.skyforged_dream;

import github.arovchinnikov.skyforged_dream.common.block.Blocks;
import github.arovchinnikov.skyforged_dream.common.entity.EntityTypes;
import github.arovchinnikov.skyforged_dream.common.entity.creature.HamsterEntity;
import github.arovchinnikov.skyforged_dream.server.effect.StatusEffects;
import github.arovchinnikov.skyforged_dream.common.item.ItemGroups;
import github.arovchinnikov.skyforged_dream.common.item.Items;
import github.arovchinnikov.skyforged_dream.server.biome.BiomeUpdates;
import github.arovchinnikov.skyforged_dream.common.feature.ConfiguredFeatures;
import github.arovchinnikov.skyforged_dream.common.feature.Features;
import github.arovchinnikov.skyforged_dream.common.feature.PlacedFeatures;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
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

		FabricDefaultAttributeRegistry.register(EntityTypes.HAMSTER, HamsterEntity.createPorcupineAttributes());
	}
}
