package github.arovchinnikov.skyforged_dream.datagen.provider;

import github.arovchinnikov.skyforged_dream.block.Blocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(Blocks.PEARL_SHELL.block())
            .add(Blocks.DEEPSLATE_ANADIUM_ORE.block());

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(Blocks.DEEPSLATE_ANADIUM_ORE.block());
    }
}
