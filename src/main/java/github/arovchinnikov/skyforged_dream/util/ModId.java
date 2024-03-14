package github.arovchinnikov.skyforged_dream.util;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import net.minecraft.util.Identifier;

public class ModId {
    public static Identifier get(String path) {
        return new Identifier(SkyforgedDream.MOD_ID, path);
    }
}
