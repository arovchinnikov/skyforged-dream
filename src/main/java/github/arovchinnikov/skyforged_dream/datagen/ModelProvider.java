package github.arovchinnikov.skyforged_dream.datagen;

import github.arovchinnikov.skyforged_dream.block.Blocks;
import github.arovchinnikov.skyforged_dream.item.Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Items.PEARL.get(), Models.GENERATED);
        itemModelGenerator.register(Items.PEARL_DUST.get(), Models.GENERATED);
        itemModelGenerator.register(Items.BLACK_PEARL.get(), Models.GENERATED);
    }
}