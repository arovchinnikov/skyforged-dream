package github.arovchinnikov.skyforged_dream.item.base;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class ModItem extends Item {
    public ModItem() {
        this(new FabricItemSettings());
    }

    public ModItem(Settings settings) {
        super(settings);
    }
}
