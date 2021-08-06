package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings;

import carpet.settings.Rule;
import carpet.settings.Validator;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.AmplifierLimit;
import net.minecraft.entity.effect.StatusEffects;

import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpBeaconsMax;
import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpbeaconsCategory;

public class RegenerationSettings extends AbstractEffectSettings {
    private static final String REGENERATION = "regeneration";
    public RegenerationSettings() {
        EffectType = StatusEffects.REGENERATION;
    }

    @Rule(
            desc="toggle xp beacons for resistance effect",
            category = {xpbeaconsCategory, REGENERATION}
    )
    public static boolean regeneration_xp_based_amplitude = true;

    @Rule(
            desc="effect amplitude ceiling for resistance. default 5 is pretty fast, but if you have the default 8000 levels, is it really OP?",
            validate = {AmplifierLimit.class},
            category = {xpbeaconsCategory, REGENERATION}
    )
    public static int regeneration_amplitude_ceiling = 5;

    @Rule(
            desc="xp ceiling in levels for resistance",
            validate = {Validator.NONNEGATIVE_NUMBER.class},
            category = {xpbeaconsCategory, REGENERATION}
    )
    public static int regeneration_xp_ceiling = xpBeaconsMax;

    @Rule(
            desc="xp drain feature toggle for regeneration",
            category = {xpbeaconsCategory, REGENERATION}
    )
    public static boolean regeneration_xp_drain = true;

    @Rule(
            desc="xp drain rate for regeneration. each beacon tick takes away (haste_xp_drain_rate * effect amplifier) xp POINTS",
            validate = {Validator.NONNEGATIVE_NUMBER.class},
            category = {xpbeaconsCategory, REGENERATION},
            strict = false
    )
    public static int regeneration_xp_drain_rate = 10;


    public int getEffectAmplitudeCeiling() {
        return regeneration_amplitude_ceiling;
    }

    public int getEffectXpCeiling() {
        return regeneration_xp_ceiling;
    }

    public boolean getXpAmplitudeToggle() {
        return regeneration_xp_based_amplitude;
    }

    public int getXpDrainRate() {
        return regeneration_xp_drain_rate;
    }

    public boolean getShouldDrainXp() {
        return regeneration_xp_drain;
    }
}