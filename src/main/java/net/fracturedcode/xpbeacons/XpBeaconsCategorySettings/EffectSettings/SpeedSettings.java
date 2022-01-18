package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings;

import carpet.settings.Rule;
import carpet.settings.Validator;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.AmplifierLimit;
import net.minecraft.entity.effect.StatusEffects;

import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpBeaconsMax;
import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpbeaconsCategory;

public class SpeedSettings extends AbstractEffectSettings {
    private static final String SPEED = "speed";
    public SpeedSettings() {
        EffectType = StatusEffects.SPEED;
    }

    @Rule(
            desc="toggle xp beacons for speed effect",
            category = {xpbeaconsCategory, SPEED}
    )
    public static boolean speed_xp_based_amplitude = true;

    @Rule(
            desc="effect amplitude ceiling for speed. default speed 6, about as fast as I'd want to go",
            validate = AmplifierLimit.class,
            category = {xpbeaconsCategory, SPEED},
            strict = false
    )
    public static int speed_amplitude_ceiling = 5;

    @Rule(
            desc="xp ceiling in levels for speed",
            validate = Validator.NONNEGATIVE_NUMBER.class,
            category = {xpbeaconsCategory, SPEED},
	        strict = false
    )
    public static int speed_xp_ceiling = xpBeaconsMax;

    @Rule(
            desc="xp drain feature toggle for speed",
            category = {xpbeaconsCategory, SPEED}
    )
    public static boolean speed_xp_drain = true;

    @Rule(
            desc="xp drain rate for haste. each beacon tick takes away (speed_xp_drain_rate * effect amplifier) xp POINTS",
            validate = {Validator.NONNEGATIVE_NUMBER.class},
            category = {xpbeaconsCategory, SPEED}
    )
    public static int speed_xp_drain_rate = 10;

    public int getEffectAmplitudeCeiling() {
        return speed_amplitude_ceiling;
    }

    public int getEffectXpCeiling() {
        return speed_xp_ceiling;
    }

    public boolean getXpAmplitudeToggle() {
        return speed_xp_based_amplitude;
    }

    public int getXpDrainRate() {
        return speed_xp_drain_rate;
    }

    public boolean getShouldDrainXp() {
        return speed_xp_drain;
    }
}