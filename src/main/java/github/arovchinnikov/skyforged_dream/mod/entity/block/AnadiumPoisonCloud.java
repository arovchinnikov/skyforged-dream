package github.arovchinnikov.skyforged_dream.mod.entity.block;

import github.arovchinnikov.skyforged_dream.mod.effect.StatusEffects;
import github.arovchinnikov.skyforged_dream.util.Time;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class AnadiumPoisonCloud extends Entity {
    private final int lifetime;

    private int ticksAfterTrigger = 0;

    private double radiusModifier = 0;

    public AnadiumPoisonCloud(EntityType<? extends Entity> type, World world) {
        super(type, world);

        lifetime = 10 * Time.second;
    }

    @Override
    public void tick() {
        ticksAfterTrigger++;
        if (ticksAfterTrigger > lifetime) {
            this.remove(RemovalReason.DISCARDED);
        }

        boolean isHalfSecond = age % Time.halfSecond != 0;
        if (isHalfSecond) {
            radiusModifier = Math.min(Math.sqrt(age) * 0.05, 0.6);
        }

        if (age % Time.millisecond != 0) {
            return;
        }

        if (this.getWorld().isClient) {
            spawnParticles();

            return;
        }

        if (age >= Time.halfSecond && isHalfSecond) {
            return;
        }

        applyEffects();
    }

    private void spawnParticles() {
        if (getWorld().isClient) {
            getWorld().addImportantParticle(
                ParticleTypes.CLOUD,
                getX() + random.nextBetween(-3, 3) * radiusModifier,
                getY() + random.nextBetween(0, 3) * radiusModifier,
                getZ() + random.nextBetween(-3, 3) * radiusModifier,
                random.nextBetween(-1, 1) * 0.01f,
                0.05f,
                random.nextBetween(-1, 1) * 0.01f
            );
        }
    }

    private void applyEffects() {
        List<LivingEntity> livingEntities = getWorld().getEntitiesByClass(
            LivingEntity.class,
            new Box(getBlockPos()).expand(3 * radiusModifier),
            e -> true
        );

        for (LivingEntity entity : livingEntities) {
            if (entity.getGroup() == EntityGroup.UNDEAD) {
                continue;
            }

            entity.addStatusEffect(
                new StatusEffectInstance(
                    StatusEffects.ANADIUM_POISON.effect(),
                    8 * Time.second,
                    0,
                    false,
                    false
                )
            );
        }
    }

    public void trigger() {
        ticksAfterTrigger = 0;
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    protected void initDataTracker() {

    }
}
