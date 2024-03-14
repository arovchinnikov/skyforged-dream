package github.arovchinnikov.skyforged_dream.common.item;


import github.arovchinnikov.skyforged_dream.common.item.Settings;
import net.minecraft.item.Item;

public interface RegisteredItem {
    Item item();
    Settings settings();
}
