package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings;

import carpet.api.settings.Rule;
import carpet.api.settings.Validator;
import carpet.api.settings.Validators;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.AmplifierLimit;
import net.minecraft.entity.effect.StatusEffects;

import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpBeaconsMax;
import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpbeaconsCategory;

public class SpeedSettings extends AbstractEffectSettings {
    private static final String SPEED = "speed";
    public SpeedSettings() {
        EffectType = StatusEffects.SPEED;
    }

    @Rule(categories = {xpbeaconsCategory, SPEED})
    public static boolean speed_xp_based_amplitude = true;

    @Rule(
            validators = AmplifierLimit.class,
            categories = {xpbeaconsCategory, SPEED},
            strict = false
    )
    public static int speed_amplitude_ceiling = 5;

    @Rule(
            validators = Validators.NonNegativeNumber.class,
            categories = {xpbeaconsCategory, SPEED},
	        strict = false
    )
    public static int speed_xp_ceiling = xpBeaconsMax;

    @Rule(categories = {xpbeaconsCategory, SPEED})
    public static boolean speed_xp_drain = true;

    @Rule(
            validators = {Validators.NonNegativeNumber.class},
            categories = {xpbeaconsCategory, SPEED}
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