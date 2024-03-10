package github.arovchinnikov.skyforged_dream.datagen;

import github.arovchinnikov.skyforged_dream.datagen.bootstrap.ConfiguredFeaturesData;
import github.arovchinnikov.skyforged_dream.datagen.bootstrap.PlacedFeaturesData;
import github.arovchinnikov.skyforged_dream.datagen.provider.BlockTagProvider;
import github.arovchinnikov.skyforged_dream.datagen.provider.LootTableProvider;
import github.arovchinnikov.skyforged_dream.datagen.provider.ModelProvider;
import github.arovchinnikov.skyforged_dream.datagen.provider.WorldGenerationProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class SkyforgedDreamDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModelProvider::new);
		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(LootTableProvider::new);
		pack.addProvider(WorldGenerationProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeaturesData::boostrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeaturesData::boostrap);
	}
}
