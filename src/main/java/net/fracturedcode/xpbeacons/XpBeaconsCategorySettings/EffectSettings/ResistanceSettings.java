package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings;

import carpet.settings.Rule;
import carpet.settings.Validator;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.AmplifierLimit;
import net.minecraft.entity.effect.StatusEffects;

import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpBeaconsMax;
import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpbeaconsCategory;

public class ResistanceSettings extends AbstractEffectSettings {
    private static final String RESISTANCE = "resistance";
    public ResistanceSettings() {
        EffectType = StatusEffects.RESISTANCE;
    }

    @Rule(
            desc="toggle xp beacons for resistance effect",
            category = {xpbeaconsCategory, RESISTANCE}
    )
    public static boolean resistance_xp_based_amplitude = true;

    @Rule(
            desc="effect amplitude ceiling for resistance. with default of 3 you can survive 100m drop no armor on half heart. 200m drop with enchanted armor easily",
            validate = {AmplifierLimit.class},
            category = {xpbeaconsCategory, RESISTANCE}
    )
    public static int resistance_amplitude_ceiling = 3;

    @Rule(
            desc="xp ceiling in levels for resistance",
            validate = {Validator.NONNEGATIVE_NUMBER.class},
            category = {xpbeaconsCategory, RESISTANCE}
    )
    public static int resistance_xp_ceiling = xpBeaconsMax;

    @Rule(
            desc="xp drain feature toggle for resistance",
            category = {xpbeaconsCategory, RESISTANCE}
    )
    public static boolean resistance_xp_drain = true;

    @Rule(
            desc="xp drain rate for resistance. each beacon tick takes away (resistance_xp_drain_rate * effect amplifier) xp POINTS",
            validate = {Validator.NONNEGATIVE_NUMBER.class},
            category = {xpbeaconsCategory, RESISTANCE},
            strict = false
    )
    public static int resistance_xp_drain_rate = 10;


    public int getEffectAmplitudeCeiling() {
        return resistance_amplitude_ceiling;
    }

    public int getEffectXpCeiling() {
        return resistance_xp_ceiling;
    }

    public boolean getXpAmplitudeToggle() {
        return resistance_xp_based_amplitude;
    }

    public int getXpDrainRate() {
        return resistance_xp_drain_rate;
    }

    public boolean getShouldDrainXp() {
        return resistance_xp_drain;
    }
}