package github.arovchinnikov.skyforged_dream.common.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public enum BlockMaterials {
    BONE(Blocks.BONE_BLOCK),
    DEEPSLATE(Blocks.DEEPSLATE),
    STONE(Blocks.STONE);

    public final AbstractBlock.Settings settings;

    BlockMaterials(Block materialReference) {
        this.settings = materialReference.getSettings();
    }
}
