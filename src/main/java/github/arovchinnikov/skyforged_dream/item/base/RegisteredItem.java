package github.arovchinnikov.skyforged_dream.item.base;


import net.minecraft.item.Item;

public interface RegisteredItem {
    Item item();
    Settings settings();
}
