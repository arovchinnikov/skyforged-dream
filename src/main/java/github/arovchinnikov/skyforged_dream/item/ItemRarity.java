package github.arovchinnikov.skyforged_dream.item;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.client.ModColor;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public enum ItemRarity {
    COMMON(ModColor.WHITE, "common"),
    RARE(ModColor.GREEN, "rare"),
    LEGENDARY(ModColor.ORANGE, "legendary"),
    MYTHICAL(ModColor.ORANGE, "mythic"),
    RELIC(ModColor.DARK_RED, "relic");

    private final ModColor color;
    private final String name;

    ItemRarity(ModColor color, String name) {
        this.color = color;
        this.name = name;
    }

    public ModColor getColor() {
        return this.color;
    }

    public MutableText getTranslation() {
        return Text.translatable(String.format("rarity.%s.%s", SkyforgedDream.MOD_ID, this.name));
    }
}
