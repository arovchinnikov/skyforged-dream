package github.arovchinnikov.skyforged_dream.util;

import github.arovchinnikov.skyforged_dream.mod.SkyforgedDream;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public enum Rarity {
    COMMON(Color.WHITE, "common"),
    RARE(Color.GREEN, "rare"),
    LEGENDARY(Color.ORANGE, "legendary"),
    MYTHICAL(Color.DARK_ORANGE, "mythical"),
    RELIC(Color.DARK_RED, "relic");

    private final Color color;
    private final String name;

    Rarity(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return this.color;
    }

    public MutableText getTranslation() {
        return Text.translatable(String.format("rarity.%s.%s", SkyforgedDream.MOD_ID, this.name));
    }
}
