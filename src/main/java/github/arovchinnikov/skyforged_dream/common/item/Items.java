package github.arovchinnikov.skyforged_dream.common.item;

import github.arovchinnikov.skyforged_dream.common.entity.EntityTypes;
import github.arovchinnikov.skyforged_dream.util.Color;
import github.arovchinnikov.skyforged_dream.util.Rarity;
import github.arovchinnikov.skyforged_dream.util.ModId;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Colors;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public enum Items implements ConfiguredItem {
    RAW_ANADIUM("raw_anadium", new Settings().withDescription()),
    PEARL("pearl"),
    BLACK_PEARL("black_pearl", new Settings().withDescription().withRarity(Rarity.LEGENDARY)),
    HAMSTER_SPAWN_EGG(
        "hamster_spawn_egg",
        () -> new SpawnEggItem(EntityTypes.HAMSTER, Color.BLUE.getRGB(), Color.GREEN.getRGB(), new FabricItemSettings()),
        new Settings().withDescription().withRarity(Rarity.LEGENDARY)
    );

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
            Registry.register(Registries.ITEM, ModId.get(value.name), value.item());
            ConfiguredItemRegistry.append(value.item().getTranslationKey(), value);
            if (value.settings.getBurnTime() > 0) {
                FuelRegistry.INSTANCE.add(value.item(), value.settings.getBurnTime());
            }
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.MAIN_GROUP).register(entries -> entries.addAll(
            Arrays.stream(Items.values()).map(item -> item.item().getDefaultStack()).toList()
        ));
    }

    public Item item() {
        return this.item;
    }

    public Settings settings() {
        return this.settings;
    }

    public static class ConfiguredItemRegistry {
        private static final Map<String, ConfiguredItem> items = new HashMap<>();

        public static void append(String name, ConfiguredItem item) {
            items.put(name, item);
        }

        public static @Nullable ConfiguredItem findByKey(String key) {
            return items.get(key);
        }

        public static @Nullable ConfiguredItem find(Item item) {
            return items.get(item.getTranslationKey());
        }
    }

    private static class DefaultItem extends Item {
        public DefaultItem() {
            this(new FabricItemSettings());
        }

        public DefaultItem(Settings settings) {
            super(settings);
        }
    }
}
