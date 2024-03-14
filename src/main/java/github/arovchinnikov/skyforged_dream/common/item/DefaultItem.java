package github.arovchinnikov.skyforged_dream.common.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class DefaultItem extends Item {
    public DefaultItem() {
        this(new FabricItemSettings());
    }

    public DefaultItem(Settings settings) {
        super(settings);
    }
}
