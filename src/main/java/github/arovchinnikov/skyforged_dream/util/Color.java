package github.arovchinnikov.skyforged_dream.util;

public enum Color {
    LIGHT_GREY(new java.awt.Color(180, 180, 180)),
    WHITE(new java.awt.Color(245, 245, 245)),
    GREEN(new java.awt.Color(75, 213, 71)),
    BLUE(new java.awt.Color(59, 145, 255)),
    ORANGE(new java.awt.Color(255, 144, 31)),
    DARK_ORANGE(new java.awt.Color(187, 67, 0)),
    DARK_RED(new java.awt.Color(173, 0, 0));

    private final java.awt.Color color;

    Color(java.awt.Color color) {
        this.color = color;
    }

    public int getRGB() {
        return this.color.getRGB();
    }
}
