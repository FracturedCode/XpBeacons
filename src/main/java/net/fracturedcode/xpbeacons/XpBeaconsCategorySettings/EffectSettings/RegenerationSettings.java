package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings;

import carpet.api.settings.Rule;
import carpet.api.settings.Validator;
import carpet.api.settings.Validators;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.AmplifierLimit;
import net.minecraft.entity.effect.StatusEffects;

import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpBeaconsMax;
import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpbeaconsCategory;

public class RegenerationSettings extends AbstractEffectSettings {
    private static final String REGENERATION = "regeneration";
    public RegenerationSettings() {
        EffectType = StatusEffects.REGENERATION;
    }

    @Rule(categories = {xpbeaconsCategory, REGENERATION})
    public static boolean regeneration_xp_based_amplitude = true;

    @Rule(
            validators = AmplifierLimit.class,
            categories = {xpbeaconsCategory, REGENERATION},
	        strict = false
    )
    public static int regeneration_amplitude_ceiling = 5;

    @Rule(
            validators = Validators.NonNegativeNumber.class,
            categories = {xpbeaconsCategory, REGENERATION},
	        strict = false
    )
    public static int regeneration_xp_ceiling = xpBeaconsMax;

    @Rule(categories = {xpbeaconsCategory, REGENERATION})
    public static boolean regeneration_xp_drain = true;

    @Rule(
            validators = {Validators.NonNegativeNumber.class},
            categories = {xpbeaconsCategory, REGENERATION},
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