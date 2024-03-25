package github.arovchinnikov.skyforged_dream.util.datagen.provider;

import github.arovchinnikov.skyforged_dream.common.block.Blocks;
import github.arovchinnikov.skyforged_dream.common.item.Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

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
        itemModelGenerator.register(Items.BLACK_PEARL.item(), Models.GENERATED);
        itemModelGenerator.register(Items.RAW_ANADIUM.item(), Models.GENERATED);

        itemModelGenerator.register(Items.HAMSTER_SPAWN_EGG.item(),
            new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}
