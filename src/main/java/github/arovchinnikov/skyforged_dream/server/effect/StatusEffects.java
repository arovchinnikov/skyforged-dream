package github.arovchinnikov.skyforged_dream.server.effect;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.server.effect.harmfull.AnadiumPoison;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public enum StatusEffects {
    ANADIUM_POISON("anadium_poison", AnadiumPoison::new);

    private final String id;
    private final StatusEffect effect;

    StatusEffects(String id, Supplier<StatusEffect> supplier) {
        this.id = id;
        this.effect = supplier.get();
    }

    public static void register() {
        for (StatusEffects value : values()) {
            Registry.register(Registries.STATUS_EFFECT, new Identifier(SkyforgedDream.MOD_ID, value.id()), value.effect());
        }
    }

    public String id() {
        return this.id;
    }

    public StatusEffect effect() {
        return this.effect;
    }
}
