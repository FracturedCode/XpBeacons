package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings;

import carpet.api.settings.Rule;
import carpet.api.settings.Validator;
import carpet.api.settings.Validators;
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
            categories = {xpbeaconsCategory, RESISTANCE}
    )
    public static boolean resistance_xp_based_amplitude = true;

    @Rule(
            validators = AmplifierLimit.class,
            categories = {xpbeaconsCategory, RESISTANCE},
	        strict = false
    )
    public static int resistance_amplitude_ceiling = 3;

    @Rule(
            validators = Validators.NonNegativeNumber.class,
            categories = {xpbeaconsCategory, RESISTANCE},
	    strict = false
    )
    public static int resistance_xp_ceiling = xpBeaconsMax;

    @Rule(
            categories = {xpbeaconsCategory, RESISTANCE}
    )
    public static boolean resistance_xp_drain = true;

    @Rule(
            validators = {Validators.NonNegativeNumber.class},
            categories = {xpbeaconsCategory, RESISTANCE},
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