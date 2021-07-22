package net.fracturedcode.xpbeacons;

import carpet.settings.Rule;
import carpet.settings.Validator;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

// This is all very verbose but this was the quickest thing I could think of that fell within the limitations of
// carpet commands
public class XpBeaconsCategorySettings {
    private static final String xpbeaconsCategory = "xpbeacons";

    // the default level ceiling of xp-based beacon status effects
    public static int xpBeaconsMax = 8000;

    public static class HasteSettings extends EffectSettings {
        private final static String HASTE = "haste";
        public HasteSettings() {
            EffectType = StatusEffects.HASTE; // to maintain language compatibility
        }

        @Rule(
                desc="toggle xp beacons for haste effect",
                category = {xpbeaconsCategory, HASTE}
        )
        public static boolean haste_xp_based_amplitude = true;

        @Rule(
                desc="effect multiplier for haste",
                validate = {Validator.PROBABILITY.class},
                category = {xpbeaconsCategory, HASTE}
        )
        public static double haste_multiplier = .3;

        @Rule(
                desc="xp ceiling in levels for haste",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, HASTE}
        )
        public static int haste_ceiling = xpBeaconsMax;


        public double getEffectMultiplier() {
            return haste_multiplier;
        }

        public int getEffectXpCeiling() {
            return haste_ceiling;
        }

        public boolean getModdedBehaviorToggle() {
            return haste_xp_based_amplitude;
        }
    }

    public static class SpeedSettings extends EffectSettings {
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
                desc="effect multiplier for speed",
                validate = {Validator.PROBABILITY.class},
                category = {xpbeaconsCategory, SPEED}
        )
        public static double speed_multiplier = .039;

        @Rule(
                desc="xp ceiling in levels for speed",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, SPEED}
        )
        public static int speed_ceiling = xpBeaconsMax;

        public double getEffectMultiplier() {
            return speed_multiplier;
        }

        public int getEffectXpCeiling() {
            return speed_ceiling;
        }

        public boolean getModdedBehaviorToggle() {
            return speed_xp_based_amplitude;
        }
    }

    public static class ResistanceSettings extends EffectSettings {
        private static final String RESISTANCE = "resistance";
        public ResistanceSettings() {
            EffectType = StatusEffects.RESISTANCE;
        }

        @Rule(
                desc="toggle xp beacons for resistance effect",
                category = {xpbeaconsCategory, RESISTANCE}
        )
        public static boolean resistance_xp_based_amplitude = true;

        @Rule(
                desc="effect multiplier for resistance",
                validate = {Validator.PROBABILITY.class},
                category = {xpbeaconsCategory, RESISTANCE}
        )
        public static double resistance_multiplier = .02;

        @Rule(
                desc="xp ceiling in levels for resistance",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, RESISTANCE}
        )
        public static int resistance_ceiling = xpBeaconsMax;


        public double getEffectMultiplier() {
            return resistance_multiplier;
        }

        public int getEffectXpCeiling() {
            return resistance_ceiling;
        }

        public boolean getModdedBehaviorToggle() {
            return resistance_xp_based_amplitude;
        }
    }

    public static class RegenerationSettings extends EffectSettings {
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
                desc="effect multiplier for resistance",
                validate = {Validator.PROBABILITY.class},
                category = {xpbeaconsCategory, REGENERATION}
        )
        public static double regeneration_multiplier = .0157;

        @Rule(
                desc="xp ceiling in levels for resistance",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, REGENERATION}
        )
        public static int regeneration_ceiling = xpBeaconsMax;


        public double getEffectMultiplier() {
            return regeneration_multiplier;
        }

        public int getEffectXpCeiling() {
            return regeneration_ceiling;
        }

        public boolean getModdedBehaviorToggle() {
            return regeneration_xp_based_amplitude;
        }
    }

    public static class JumpBoostSettings extends EffectSettings {
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
                desc="effect multiplier for resistance",
                validate = {Validator.PROBABILITY.class},
                category = {xpbeaconsCategory, JUMP}
        )
        public static double jump_boost_multiplier = .009;

        @Rule(
                desc="xp ceiling in levels for resistance",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, JUMP}
        )
        public static int jump_boost_ceiling = xpBeaconsMax;


        public double getEffectMultiplier() {
            return jump_boost_multiplier;
        }

        public int getEffectXpCeiling() {
            return jump_boost_ceiling;
        }

        public boolean getModdedBehaviorToggle() {
            return jump_boost_xp_based_amplitude;
        }
    }

    public static class StrengthSettings extends EffectSettings {
        private static final String STRENGTH = "strength";
        public StrengthSettings() {
            EffectType = StatusEffects.STRENGTH;
        }

        @Rule(
                desc="toggle xp beacons for resistance effect",
                category = {xpbeaconsCategory, STRENGTH}
        )
        public static boolean strength_xp_based_amplitude = true;

        @Rule(
                desc="effect multiplier for resistance",
                validate = {Validator.PROBABILITY.class},
                category = {xpbeaconsCategory, STRENGTH}
        )
        public static double strength_multiplier = .2;

        @Rule(
                desc="xp ceiling in levels for resistance",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, STRENGTH}
        )
        public static int strength_ceiling = xpBeaconsMax;


        public double getEffectMultiplier() {
            return strength_multiplier;
        }

        public int getEffectXpCeiling() {
            return strength_ceiling;
        }

        public boolean getModdedBehaviorToggle() {
            return strength_xp_based_amplitude;
        }
    }
}
