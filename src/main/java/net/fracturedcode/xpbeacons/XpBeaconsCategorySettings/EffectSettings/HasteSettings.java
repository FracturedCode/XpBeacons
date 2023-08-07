package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings;

import carpet.api.settings.Rule;
import carpet.api.settings.Validator;
import carpet.api.settings.Validators;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.AmplifierLimit;
import net.minecraft.entity.effect.StatusEffects;

import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpBeaconsMax;
import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpbeaconsCategory;

public class HasteSettings extends AbstractEffectSettings {
    private final static String HASTE = "haste";
    public HasteSettings() {
        EffectType = StatusEffects.HASTE;
    }

    @Rule(categories = {xpbeaconsCategory, HASTE})
    public static boolean haste_xp_based_amplitude = true;

    @Rule(
            validators = AmplifierLimit.class,
            categories = {xpbeaconsCategory, HASTE},
            strict = false
    )
    public static int haste_amplitude_ceiling = 10;

    @Rule(
            validators = Validators.NonNegativeNumber.class,
            categories = {xpbeaconsCategory, HASTE},
		    strict = false
    )
    public static int haste_xp_ceiling = xpBeaconsMax;

    @Rule(categories = {xpbeaconsCategory, HASTE})
    public static boolean haste_xp_drain = true;

    @Rule(
            validators = {Validators.NonNegativeNumber.class},
            categories = {xpbeaconsCategory, HASTE}
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