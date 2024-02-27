package github.arovchinnikov.skyforged_dream.client;

import java.awt.*;

public enum ModColor {
    WHITE(new Color(245, 245, 245)),
    LIGHT_GREY(new Color(190, 190, 190)),
    ORANGE(new Color(211, 103, 7)),
    DARK_RED(new Color(244, 0, 0));

    private final Color color;

    ModColor(Color color) {
        this.color = color;
    }

    public int getRGB() {
        return this.color.getRGB();
    }
}
