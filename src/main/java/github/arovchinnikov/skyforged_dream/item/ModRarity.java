package github.arovchinnikov.skyforged_dream.item;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.client.ModColor;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.awt.*;

public enum ModRarity {
    COMMON(ModColor.WHITE, "common"),
    MYTHICAL(ModColor.ORANGE, "mythic");
    private final ModColor color;
    private final String name;

    ModRarity(ModColor color, String name) {
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
