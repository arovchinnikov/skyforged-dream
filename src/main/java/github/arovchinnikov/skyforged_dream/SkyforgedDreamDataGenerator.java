package github.arovchinnikov.skyforged_dream;

import github.arovchinnikov.skyforged_dream.datagen.BlockTagProvider;
import github.arovchinnikov.skyforged_dream.datagen.LootTableProvider;
import github.arovchinnikov.skyforged_dream.datagen.ModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SkyforgedDreamDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModelProvider::new);
		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(LootTableProvider::new);
	}
}
