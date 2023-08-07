package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings;

import carpet.api.settings.Rule;
import carpet.api.settings.Validator;
import carpet.api.settings.Validators;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.AmplifierLimit;
import net.minecraft.entity.effect.StatusEffects;

import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpBeaconsMax;
import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpbeaconsCategory;

public class JumpBoostSettings extends AbstractEffectSettings {
    private static final String JUMP = "jump_boost";
    public JumpBoostSettings() {
        EffectType = StatusEffects.JUMP_BOOST;
    }

    @Rule(categories = {xpbeaconsCategory, JUMP})
    public static boolean jump_boost_xp_based_amplitude = true;

    @Rule(
            validators = {AmplifierLimit.class},
            categories = {xpbeaconsCategory, JUMP},
	        strict = false
    )
    public static int jump_boost_amplitude_ceiling = 2;

    @Rule(
            validators = {Validators.NonNegativeNumber.class},
            categories = {xpbeaconsCategory, JUMP},
	        strict = false
    )
    public static int jump_boost_xp_ceiling = xpBeaconsMax;

    @Rule(
            categories = {xpbeaconsCategory, JUMP}
    )
    public static boolean jump_boost_xp_drain = true;

    @Rule(
            validators = {Validators.NonNegativeNumber.class},
            categories = {xpbeaconsCategory, JUMP},
            strict = false
    )
    public static int jump_boost_xp_drain_rate = 10;


    public int getEffectAmplitudeCeiling() {
        return jump_boost_amplitude_ceiling;
    }

    public int getEffectXpCeiling() {
        return jump_boost_xp_ceiling;
    }

    public boolean getXpAmplitudeToggle() {
        return jump_boost_xp_based_amplitude;
    }

    public int getXpDrainRate() {
        return jump_boost_xp_drain_rate;
    }

    public boolean getShouldDrainXp() {
        return jump_boost_xp_drain;
    }
}