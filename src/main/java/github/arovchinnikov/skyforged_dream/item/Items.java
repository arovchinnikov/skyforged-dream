package github.arovchinnikov.skyforged_dream.item;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.item.base.ModItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.function.Supplier;

public enum Items {
    DARK_SILVER_ORE("dark_silver_ore", ModItem::new),
    DARK_SILVER_INGOT("dark_silver_ingot", ModItem::new);

    public final String name;
    public final Supplier<ModItem> itemSupplier;
    public final Integer burnTime;

    private ModItem item;

    Items(String pathName, Supplier<ModItem> itemSupplier) {
        this(pathName, itemSupplier, null);
    }

    Items(String pathName, Supplier<ModItem> itemSupplier, Integer burnTime) {
        this.name = pathName;
        this.itemSupplier = itemSupplier;
        this.burnTime = burnTime;
    }

    public static void register() {
        for (Items value : values()) {
            Registry.register(Registries.ITEM, new Identifier(SkyforgedDream.MOD_ID, value.name), value.get());
            if (value.burnTime != null && value.burnTime > 0) {
                FuelRegistry.INSTANCE.add(value.get(), value.burnTime);
            }
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.ITEMS_GROUP).register(entries -> entries.addAll(
            Arrays.stream(Items.values()).map(item -> item.get().getDefaultStack()).toList()
        ));
    }

    public ModItem get() {
        if (item == null) {
            item = itemSupplier.get();
        }
        return item;
    }
}
