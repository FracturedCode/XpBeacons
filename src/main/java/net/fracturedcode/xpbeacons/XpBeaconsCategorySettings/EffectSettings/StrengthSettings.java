package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings;

import carpet.settings.Rule;
import carpet.settings.Validator;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.AmplifierLimit;
import net.minecraft.entity.effect.StatusEffects;

import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpBeaconsMax;
import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpbeaconsCategory;

public class StrengthSettings extends AbstractEffectSettings {
    private static final String STRENGTH = "strength";
    public StrengthSettings() {
        EffectType = StatusEffects.STRENGTH;
    }

    @Rule(
            desc="toggle xp beacons for strength effect",
            category = {xpbeaconsCategory, STRENGTH}
    )
    public static boolean strength_xp_based_amplitude = true;

    @Rule(
            desc="effect amplitude ceiling for strength. one hit a zombie with your fists in this default.",
            validate = AmplifierLimit.class,
            category = {xpbeaconsCategory, STRENGTH}
    )
    public static int strength_amplitude_ceiling = 4;

    @Rule(
            desc="xp ceiling in levels for strength",
            validate = Validator.NONNEGATIVE_NUMBER.class,
            category = {xpbeaconsCategory, STRENGTH}
    )
    public static int strength_xp_ceiling = xpBeaconsMax;

    @Rule(
            desc="xp drain feature toggle for strength",
            category = {xpbeaconsCategory, STRENGTH}
    )
    public static boolean strength_xp_drain = true;

    @Rule(
            desc="xp drain rate for strength. each beacon tick takes away (strength_xp_drain_rate * effect amplifier) xp POINTS",
            validate = {Validator.NONNEGATIVE_NUMBER.class},
            category = {xpbeaconsCategory, STRENGTH},
            strict = false
    )
    public static int strength_xp_drain_rate = 10;


    public int getEffectAmplitudeCeiling() {
        return strength_amplitude_ceiling;
    }

    public int getEffectXpCeiling() {
        return strength_xp_ceiling;
    }

    public boolean getXpAmplitudeToggle() {
        return strength_xp_based_amplitude;
    }

    public int getXpDrainRate() {
        return strength_xp_drain_rate;
    }

    public boolean getShouldDrainXp() {
        return strength_xp_drain;
    }
}