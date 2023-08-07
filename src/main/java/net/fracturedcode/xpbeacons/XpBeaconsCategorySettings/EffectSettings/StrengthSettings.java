package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings;

import carpet.api.settings.Rule;
import carpet.api.settings.Validator;
import carpet.api.settings.Validators;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.AmplifierLimit;
import net.minecraft.entity.effect.StatusEffects;

import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpBeaconsMax;
import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpbeaconsCategory;

public class StrengthSettings extends AbstractEffectSettings {
    private static final String STRENGTH = "strength";
    public StrengthSettings() {
        EffectType = StatusEffects.STRENGTH;
    }

    @Rule(categories = {xpbeaconsCategory, STRENGTH})
    public static boolean strength_xp_based_amplitude = true;

    @Rule(
            validators = AmplifierLimit.class,
            categories = {xpbeaconsCategory, STRENGTH},
	        strict = false
    )
    public static int strength_amplitude_ceiling = 4;

    @Rule(
            validators = Validators.NonNegativeNumber.class,
            categories = {xpbeaconsCategory, STRENGTH},
	        strict = false
    )
    public static int strength_xp_ceiling = xpBeaconsMax;

    @Rule(categories = {xpbeaconsCategory, STRENGTH})
    public static boolean strength_xp_drain = true;

    @Rule(
            validators = {Validators.NonNegativeNumber.class},
            categories = {xpbeaconsCategory, STRENGTH},
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