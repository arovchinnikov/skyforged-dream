package github.arovchinnikov.skyforged_dream.item.base;

import github.arovchinnikov.skyforged_dream.util.Rarity;
public class Settings {
    private int burnTime = 0;
    private boolean hasDescription = false;
    private Rarity rarity = Rarity.COMMON;

    public Settings withBurnTime(int time) {
        this.burnTime = time;
        return this;
    }

    public Settings withDescription() {
        this.hasDescription = true;
        return this;
    }

    public Settings withRarity(Rarity rarity) {
        this.rarity = rarity;
        return this;
    }

    public int getBurnTime() {
        return this.burnTime;
    }

    public boolean isHasDescription() {
        return this.hasDescription;
    }

    public Rarity getRarity() {
        return this.rarity;
    }
}
