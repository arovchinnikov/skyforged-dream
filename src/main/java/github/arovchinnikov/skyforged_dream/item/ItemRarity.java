package github.arovchinnikov.skyforged_dream.item;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.client.Colors;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public enum ItemRarity {
    COMMON(Colors.WHITE, "common"),
    RARE(Colors.GREEN, "rare"),
    LEGENDARY(Colors.ORANGE, "legendary"),
    MYTHICAL(Colors.DARK_ORANGE, "mythical"),
    RELIC(Colors.DARK_RED, "relic");

    private final Colors color;
    private final String name;

    ItemRarity(Colors color, String name) {
        this.color = color;
        this.name = name;
    }

    public Colors getColor() {
        return this.color;
    }

    public MutableText getTranslation() {
        return Text.translatable(String.format("rarity.%s.%s", SkyforgedDream.MOD_ID, this.name));
    }
}
