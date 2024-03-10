package github.arovchinnikov.skyforged_dream.util.helper;

import net.minecraft.item.*;

public class ItemHelper {
    public static boolean isTool(Item item) {
        return item instanceof AxeItem || item instanceof SwordItem
            || item instanceof PickaxeItem || item instanceof ShovelItem;
    }
}
