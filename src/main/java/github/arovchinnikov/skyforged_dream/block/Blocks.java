package github.arovchinnikov.skyforged_dream.block;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.block.base.BlockReference;
import github.arovchinnikov.skyforged_dream.block.base.ModBlock;
import github.arovchinnikov.skyforged_dream.item.ItemGroups;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.function.Supplier;

public enum Blocks {
    DARK_SILVER_BLOCK("dark_silver_block", () -> new ModBlock(BlockReference.IRON_BLOCK));

    public final String name;
    public final Supplier<ModBlock> blockSupplier;
    public final Integer burnTime;
    private ModBlock block;

    Blocks(String name, Supplier<ModBlock> blockSupplier) {
        this(name, blockSupplier, null);
    }

    Blocks(String name, Supplier<ModBlock> blockSupplier, Integer burnTime) {
        this.name = name;
        this.blockSupplier = blockSupplier;
        this.burnTime = burnTime;
    }

    public static void register() {
        for (Blocks value : values()) {
            Registry.register(Registries.BLOCK, new Identifier(SkyforgedDream.MOD_ID, value.name), value.get());
            Registry.register(Registries.ITEM, new Identifier(SkyforgedDream.MOD_ID, value.name), value.get().getBlockItem());
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.ITEMS_GROUP).register(entries -> entries.addAll(
            Arrays.stream(Blocks.values()).map(item -> item.get().asItem().getDefaultStack()).toList()
        ));
    }

    public ModBlock get() {
        if (this.block == null) {
            this.block = this.blockSupplier.get();
        }

        return this.block;
    }
}
