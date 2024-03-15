package github.arovchinnikov.skyforged_dream.util.helper;

import net.minecraft.item.*;

public class ItemHelper {
    public static boolean isTool(Item item) {
        return item instanceof AxeItem || item instanceof PickaxeItem || item instanceof ShovelItem;
    }

    public static boolean isWeapon(Item item) {
        return item instanceof BowItem || isMeleeWeapon(item);
    }

    public static boolean isMeleeWeapon(Item item) {
        return item instanceof SwordItem || item instanceof TridentItem;
    }

    public static boolean isArmor(Item item) {
        return item instanceof ArmorItem;
    }

    public static boolean isEquipment(Item item) {
        return isTool(item) || isWeapon(item) || isArmor(item);
    }
}
