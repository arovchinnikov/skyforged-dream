package github.arovchinnikov.skyforged_dream.common.item;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.util.Rarity;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.function.Supplier;

public enum Items implements RegisteredItem {
    RAW_ANADIUM("raw_anadium", new Settings().withDescription()),
    PEARL("pearl"),
    BLACK_PEARL("black_pearl", new Settings().withDescription().withRarity(Rarity.LEGENDARY));

    private final String name;
    private final Settings settings;
    private final Item item;

    Items(String name) {
        this(name, DefaultItem::new, new Settings());
    }

    Items(String name, Supplier<Item> itemSupplier) {
        this(name, itemSupplier, new Settings());
    }

    Items(String name, Settings settings) {
        this(name, DefaultItem::new, settings);
    }

    Items(String name, Supplier<Item> itemSupplier, Settings settings) {
        this.name = name;
        this.item = itemSupplier.get();
        this.settings = settings;
    }

    public static void register() {
        for (Items value : values()) {
            Registry.register(Registries.ITEM, new Identifier(SkyforgedDream.MOD_ID, value.name), value.item());
            RegisteredItems.append(value.item().getTranslationKey(), value);
            if (value.settings.getBurnTime() > 0) {
                FuelRegistry.INSTANCE.add(value.item(), value.settings.getBurnTime());
            }
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.MAIN_GROUP).register(entries -> entries.addAll(
            Arrays.stream(Items.values()).map(item -> item.item().getDefaultStack()).toList()
        ));
    }

    public Item item() {
        return item;
    }

    public Settings settings() {
        return this.settings;
    }
}
