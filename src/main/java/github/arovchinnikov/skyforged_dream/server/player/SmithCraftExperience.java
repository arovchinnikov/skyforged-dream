package github.arovchinnikov.skyforged_dream.server.player;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.PersistentState;

public class SmithCraftExperience extends PersistentState {
    private int value;

    private static final String nbtName = "smithCraftExperience";
    private static final int experienceCap = 90000;

    public SmithCraftExperience(int value) {
        this.value = value;
    }

    public static SmithCraftExperience readNbt(NbtCompound nbt) {
        return new SmithCraftExperience(nbt.getInt(nbtName));
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putInt(nbtName, value);

        return nbt;
    }


    public boolean add(int value) {
        int newValue = this.value += value;
        if (newValue > experienceCap) {
            return false;
        }

        this.markDirty();
        return true;
    }

    public int get() {
        return value;
    }

    public int rank() {
        return value % 3000;
    }
}
