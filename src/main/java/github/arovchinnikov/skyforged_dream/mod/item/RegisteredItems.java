package github.arovchinnikov.skyforged_dream.mod.item;

import github.arovchinnikov.skyforged_dream.mod.item.base.RegisteredItem;
import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class RegisteredItems {
    private static final Map<String, RegisteredItem> items = new HashMap<>();

    public static void append(String name, RegisteredItem item) {
        items.put(name, item);
    }

    public static @Nullable RegisteredItem findByKey(String key) {
        return items.get(key);
    }

    public static @Nullable RegisteredItem find(Item item) {
        return items.get(item.getTranslationKey());
    }
}
