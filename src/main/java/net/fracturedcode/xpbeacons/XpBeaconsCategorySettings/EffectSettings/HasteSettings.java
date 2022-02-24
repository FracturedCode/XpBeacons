package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings;

import carpet.settings.Rule;
import carpet.settings.Validator;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.AmplifierLimit;
import net.minecraft.entity.effect.StatusEffects;

import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpBeaconsMax;
import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpbeaconsCategory;

public class HasteSettings extends AbstractEffectSettings {
    private final static String HASTE = "haste";
    public HasteSettings() {
        EffectType = StatusEffects.HASTE;
    }

    @Rule(
            desc="toggle xp beacons for haste effect",
            category = {xpbeaconsCategory, HASTE}
    )
    public static boolean haste_xp_based_amplitude = true;

    @Rule(
            desc="effect amplitude ceiling for haste. default maybe a bit OP, play around with this one; mining obsidian is like mining stone without enchants or haste",
            validate = AmplifierLimit.class,
            category = {xpbeaconsCategory, HASTE},
            strict = false
    )
    public static int haste_amplitude_ceiling = 10;

    @Rule(
            desc="xp ceiling in levels for haste",
            validate = Validator.NONNEGATIVE_NUMBER.class,
            category = {xpbeaconsCategory, HASTE},
		    strict = false
    )
    public static int haste_xp_ceiling = xpBeaconsMax;

    @Rule(
            desc="xp drain feature toggle for haste",
            category = {xpbeaconsCategory, HASTE}
    )
    public static boolean haste_xp_drain = true;

    @Rule(
            desc="xp drain rate for haste. each beacon tick takes away (haste_xp_drain_rate * effect amplifier) xp POINTS",
            validate = {Validator.NONNEGATIVE_NUMBER.class},
            category = {xpbeaconsCategory, HASTE}
    )
    public static int haste_xp_drain_rate = 10;

    public int getEffectAmplitudeCeiling() {
        return haste_amplitude_ceiling;
    }

    public int getEffectXpCeiling() {
        return haste_xp_ceiling;
    }

    public boolean getXpAmplitudeToggle() {
        return haste_xp_based_amplitude;
    }

    public int getXpDrainRate() {
        return haste_xp_drain_rate;
    }

    public boolean getShouldDrainXp() {
        return haste_xp_drain;
    }
}