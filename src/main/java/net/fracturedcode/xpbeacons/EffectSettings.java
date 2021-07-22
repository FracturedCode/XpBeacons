package net.fracturedcode.xpbeacons;

import net.minecraft.entity.effect.StatusEffect;

public abstract class EffectSettings {
    protected StatusEffect EffectType;
    public StatusEffect getEffect() {
        return EffectType;
    }

    public abstract double getEffectMultiplier();
    public abstract int getEffectXpCeiling();
    public abstract boolean getModdedBehaviorToggle();
}

