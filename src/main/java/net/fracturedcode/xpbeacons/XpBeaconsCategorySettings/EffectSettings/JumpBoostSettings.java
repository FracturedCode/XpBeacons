package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings;

import carpet.settings.Rule;
import carpet.settings.Validator;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.AmplifierLimit;
import net.minecraft.entity.effect.StatusEffects;

import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpBeaconsMax;
import static net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings.xpbeaconsCategory;

public class JumpBoostSettings extends AbstractEffectSettings {
    private static final String JUMP = "jump_boost";
    public JumpBoostSettings() {
        EffectType = StatusEffects.JUMP_BOOST;
    }

    @Rule(
            desc="toggle xp beacons for resistance effect",
            category = {xpbeaconsCategory, JUMP}
    )
    public static boolean jump_boost_xp_based_amplitude = true;

    @Rule(
            desc="effect amplitude ceiling for jump boost",
            validate = {AmplifierLimit.class},
            category = {xpbeaconsCategory, JUMP}
    )
    public static int jump_boost_amplitude_ceiling = 2;

    @Rule(
            desc="xp ceiling in levels for jump boost",
            validate = {Validator.NONNEGATIVE_NUMBER.class},
            category = {xpbeaconsCategory, JUMP}
    )
    public static int jump_boost_xp_ceiling = xpBeaconsMax;

    @Rule(
            desc="xp drain feature toggle for jump boost",
            category = {xpbeaconsCategory, JUMP}
    )
    public static boolean jump_boost_xp_drain = true;

    @Rule(
            desc="xp drain rate for jump boost. each beacon tick takes away (jump_boost_xp_drain_rate * effect amplifier) xp POINTS",
            validate = {Validator.NONNEGATIVE_NUMBER.class},
            category = {xpbeaconsCategory, JUMP},
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