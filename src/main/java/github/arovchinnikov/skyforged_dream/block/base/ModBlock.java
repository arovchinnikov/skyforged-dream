package github.arovchinnikov.skyforged_dream.block.base;

import github.arovchinnikov.skyforged_dream.item.ModRarity;
import github.arovchinnikov.skyforged_dream.item.base.ModBlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

public class ModBlock extends Block {
    private final ModBlockItem blockItem;

    public ModBlock(BlockReference reference) {
        this(reference, ModRarity.COMMON, false);
    }
    public ModBlock(BlockReference reference, ModRarity rarity, boolean hasDescription) {
        super(FabricBlockSettings.copyOf(reference.getSettings()));

        this.blockItem = new ModBlockItem(this, new FabricItemSettings(), rarity, hasDescription);
    }

    public ModBlockItem getBlockItem() {
        return this.blockItem;
    }
}
