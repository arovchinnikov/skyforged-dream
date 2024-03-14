package github.arovchinnikov.skyforged_dream.common.item;


import net.minecraft.item.Item;

public interface ConfiguredItem {
    Item item();
    Settings settings();
}
