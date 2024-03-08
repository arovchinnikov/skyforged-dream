package github.arovchinnikov.skyforged_dream.client;

import java.awt.*;

public enum Colors {
    LIGHT_GREY(new Color(190, 190, 190)),
    WHITE(new Color(245, 245, 245)),
    GREEN(new Color(75, 213, 71)),
    BLUE(new Color(59, 145, 255)),
    ORANGE(new Color(255, 144, 31)),
    DARK_ORANGE(new Color(187, 67, 0)),
    DARK_RED(new Color(173, 0, 0));

    private final Color color;

    Colors(Color color) {
        this.color = color;
    }

    public int getRGB() {
        return this.color.getRGB();
    }
}
