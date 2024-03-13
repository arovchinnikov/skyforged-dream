package github.arovchinnikov.skyforged_dream.mod.entity;

import github.arovchinnikov.skyforged_dream.mod.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.mod.entity.block.AnadiumPoisonCloud;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public enum EntityTypes {
    ANADIUM_POISON_CLOUD("anadium_poison_cloud");
    private final Identifier id;
    private EntityType<? extends Entity> entityType;

    EntityTypes(String name) {
        this.id = new Identifier(SkyforgedDream.MOD_ID, name);
    }

    public static void register() {
        for (EntityTypes value : values()) {
            value.entityType = Registry.register(
                Registries.ENTITY_TYPE,
                value.id(),
                FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, AnadiumPoisonCloud::new).build()
            );
        }
    }

    public Identifier id() {
        return this.id;
    }

    public EntityType<? extends Entity> entityType() {
        return this.entityType;
    }
}
