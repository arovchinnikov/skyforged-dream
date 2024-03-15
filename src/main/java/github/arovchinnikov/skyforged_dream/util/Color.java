package github.arovchinnikov.skyforged_dream.util;

public enum Color {
    LIGHT_GREY(new java.awt.Color(180, 180, 180)),
    WHITE(new java.awt.Color(245, 245, 245)),
    GREEN(new java.awt.Color(64, 255, 151)),
    BLUE(new java.awt.Color(9, 169, 255)),
    YELLOW(new java.awt.Color(255, 202, 30)),
    ORANGE(new java.awt.Color(255, 165, 29)),
    DARK_ORANGE(new java.awt.Color(241, 93, 7)),
    DARK_RED(new java.awt.Color(225, 0, 0));

    private final java.awt.Color color;

    Color(java.awt.Color color) {
        this.color = color;
    }

    public int getRGB() {
        return this.color.getRGB();
    }
}
