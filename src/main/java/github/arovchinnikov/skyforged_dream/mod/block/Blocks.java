package github.arovchinnikov.skyforged_dream.mod.block;

import github.arovchinnikov.skyforged_dream.mod.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.mod.block.resource.DeepslateAnadiumOre;
import github.arovchinnikov.skyforged_dream.mod.block.resource.PearlShell;
import github.arovchinnikov.skyforged_dream.mod.item.ItemGroups;
import github.arovchinnikov.skyforged_dream.mod.item.RegisteredItems;
import github.arovchinnikov.skyforged_dream.mod.item.base.RegisteredItem;
import github.arovchinnikov.skyforged_dream.mod.item.base.Settings;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.function.Supplier;

public enum Blocks implements RegisteredItem {
    DEEPSLATE_ANADIUM_ORE("deepslate_anadium_ore_block", DeepslateAnadiumOre::new, new Settings()),
    PEARL_SHELL("pearl_shell", PearlShell::new, new Settings().withDescription());

    public final String name;
    private final Block block;
    private final BlockItem item;
    private final Settings itemSettings;

    Blocks(String name, Supplier<Block> blockSupplier) {
        this(name, blockSupplier, new Settings());
    }

    Blocks(String name, Supplier<Block> blockSupplier, Settings itemSettings) {
        this.name = name;
        this.block = blockSupplier.get();
        this.item = new BlockItem(this.block, new FabricItemSettings());
        this.itemSettings = itemSettings;
    }

    public static void register() {
        for (Blocks value : values()) {
            Registry.register(Registries.BLOCK, new Identifier(SkyforgedDream.MOD_ID, value.name), value.block());
            Registry.register(Registries.ITEM, new Identifier(SkyforgedDream.MOD_ID, value.name), value.item());
            RegisteredItems.append(value.block.getTranslationKey(), value);
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.MAIN_GROUP).register(entries -> entries.addAll(
            Arrays.stream(Blocks.values()).map(item -> item.block().asItem().getDefaultStack()).toList()
        ));
    }

    public Block block() {
        return this.block;
    }

    public Item item() {
        return this.item;
    }

    public Settings settings() {
        return this.itemSettings;
    }
}
