package github.arovchinnikov.skyforged_dream.block.base;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public enum BlockReference {
    WOOD(Blocks.OAK_WOOD),
    IRON_BLOCK(Blocks.IRON_BLOCK),
    STONE(Blocks.STONE);
    private final AbstractBlock.Settings settings;

    BlockReference(Block blockWithSettings) {
        this.settings = blockWithSettings.getSettings();
    }

    public AbstractBlock.Settings getSettings() {
        return this.settings;
    }
}
