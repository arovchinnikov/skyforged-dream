package github.arovchinnikov.skyforged_dream.common.entity;

import github.arovchinnikov.skyforged_dream.SkyforgedDream;
import github.arovchinnikov.skyforged_dream.common.entity.ambient.AnadiumPoisonCloud;
import github.arovchinnikov.skyforged_dream.common.entity.creature.HamsterEntity;
import github.arovchinnikov.skyforged_dream.util.ModId;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EntityTypes {
    public static final EntityType<AnadiumPoisonCloud> ANADIUM_POISON_CLOUD = Registry.register(
        Registries.ENTITY_TYPE,
        ModId.get("anadium_poison_cloud"),
        FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, AnadiumPoisonCloud::new).build()
    );

    public static final EntityType<HamsterEntity> HAMSTER = Registry.register(Registries.ENTITY_TYPE,
        ModId.get("hamster"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HamsterEntity::new)
            .dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static void register() {
        SkyforgedDream.LOGGER.debug("Entity types loaded");
    }
}
