package github.arovchinnikov.skyforged_dream.datagen.provider;

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
        blockStateModelGenerator.registerSimpleCubeAll(Blocks.DEEPSLATE_ANADIUM_ORE.block());
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Items.PEARL.item(), Models.GENERATED);
        itemModelGenerator.register(Items.PEARL_DUST.item(), Models.GENERATED);
        itemModelGenerator.register(Items.BLACK_PEARL.item(), Models.GENERATED);
        itemModelGenerator.register(Items.RAW_ANADIUM.item(), Models.GENERATED);
    }
}
