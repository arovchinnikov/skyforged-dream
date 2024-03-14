package github.arovchinnikov.skyforged_dream.util.datagen.provider;

import github.arovchinnikov.skyforged_dream.common.block.Blocks;
import github.arovchinnikov.skyforged_dream.common.item.Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class LootTableProvider extends FabricBlockLootTableProvider {

    public LootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(Blocks.PEARL_SHELL.block());

        addDrop(
            Blocks.DEEPSLATE_ANADIUM_ORE.block(),
            copperLikeOreDrops(Blocks.DEEPSLATE_ANADIUM_ORE.block(), Items.RAW_ANADIUM.item())
        );
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(
            drop,
            this.applyExplosionDecay(
                drop,
                ((LeafEntry.Builder<?>) ItemEntry.
                    builder(item).
                    apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)))).
                    apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
            )
        );
    }
}
