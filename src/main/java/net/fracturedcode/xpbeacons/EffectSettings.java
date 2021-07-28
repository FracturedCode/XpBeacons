package net.fracturedcode.xpbeacons;

import net.minecraft.entity.effect.StatusEffect;

public abstract class EffectSettings {
    protected StatusEffect EffectType;
    public StatusEffect getEffect() {
        return EffectType;
    }

    public abstract int getEffectAmplitudeCeiling();
    public abstract int getEffectXpCeiling();
    public abstract boolean getXpAmplitudeToggle();
    public abstract int getXpDrainRate();
    public abstract boolean getShouldDrainXp();
}