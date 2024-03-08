package github.arovchinnikov.skyforged_dream.item;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.item.base.RegisteredItem;
import github.arovchinnikov.skyforged_dream.item.base.ModItem;
import github.arovchinnikov.skyforged_dream.item.base.Settings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.function.Supplier;

public enum Items implements RegisteredItem {
    PEARL("pearl", ModItem::new),
    BLACK_PEARL("black_pearl", ModItem::new, new Settings().withDescription().withRarity(ItemRarity.LEGENDARY)),
    PEARL_DUST("pearl_dust", ModItem::new);

    private final String name;
    private final Settings settings;
    private final Item item;

    Items(String pathName, Supplier<Item> itemSupplier) {
        this(pathName, itemSupplier, new Settings());
    }

    Items(String pathName, Supplier<Item> itemSupplier, Settings settings) {
        this.name = pathName;
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
