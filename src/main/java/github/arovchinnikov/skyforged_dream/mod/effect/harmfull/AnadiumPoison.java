package github.arovchinnikov.skyforged_dream.mod.effect.harmfull;

import github.arovchinnikov.skyforged_dream.util.Time;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class AnadiumPoison extends StatusEffect {
    private Integer oxygen;
    private boolean millisecondTick = false;

    public AnadiumPoison() {
        super(StatusEffectCategory.HARMFUL, 0x0000FF);
    }

    @Override
    public void onApplied(AttributeContainer attributeContainer, int amplifier) {
        oxygen = null;

        super.onApplied(attributeContainer, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getGroup() == EntityGroup.UNDEAD) {
            return;
        }

        if (oxygen == null) {
            oxygen = entity.getAir();
        }

        if (oxygen > 0) {
            oxygen = Math.max(oxygen - 2, 0);
        }

        entity.setAir(oxygen);

        if (oxygen == 0 && millisecondTick) {
            entity.damage(entity.getDamageSources().magic(), 1);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        millisecondTick = duration % Time.millisecond == 0;

        return true;
    }
}
