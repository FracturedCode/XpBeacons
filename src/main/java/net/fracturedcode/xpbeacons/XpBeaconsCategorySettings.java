package net.fracturedcode.xpbeacons;

import carpet.settings.ParsedRule;
import carpet.settings.Rule;
import carpet.settings.Validator;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.command.ServerCommandSource;

// This is all very verbose but this was the quickest thing I could think of that fell within the limitations of
// carpet commands
public class XpBeaconsCategorySettings {
    private static class AmplifierLimit extends Validator<Integer> {
        @Override
        public Integer validate(ServerCommandSource source, ParsedRule<Integer> currentRule, Integer newValue, String string) {
            return (newValue >= 0 && newValue <= 255) ? newValue : null;
        }
        @Override
        public String description() { return "You must choose a value from 0 to 255"; }
    }

    private static final String xpbeaconsCategory = "xpbeacons";

    // the default level ceiling of xp-based beacon status effects
    public static int xpBeaconsMax = 8000;

    public static class BeaconSettings {
        private final static String beaconsCategory = "beacons";

        @Rule(
                desc="set beacon tick rate in game ticks per beacon tick",
                category = {xpbeaconsCategory, beaconsCategory},
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                strict = false
        )
        public static int beacon_tick_rate = 80;

        @Rule(
                desc="define the max pyramid level that affects the beacon",
                category = {xpbeaconsCategory, beaconsCategory},
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                strict = false
        )
        public static int beacon_max_pyramid_level = 4;

        @Rule(
                desc="(reach multiplier * beacon level) + 10 = reach",
                category = {xpbeaconsCategory, beaconsCategory},
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                strict = false
        )
        public static int beacon_reach_multiplier = 10;
    }

    public static class HasteSettings extends EffectSettings {
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
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, HASTE}
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
                desc="effect amplitude ceiling for speed. default speed 6, about as fast as I'd want to go",
                validate = {AmplifierLimit.class},
                category = {xpbeaconsCategory, SPEED},
                strict = false
        )
        public static int speed_amplitude_ceiling = 5;

        @Rule(
                desc="xp ceiling in levels for speed",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, SPEED}
        )
        public static int speed_xp_ceiling = xpBeaconsMax;

        @Rule(
                desc="xp drain feature toggle for speed",
                category = {xpbeaconsCategory, SPEED}
        )
        public static boolean speed_xp_drain = true;

        @Rule(
                desc="xp drain rate for haste. each beacon tick takes away (haste_xp_drain_rate * effect amplifier) xp POINTS",
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
                desc="effect amplitude ceiling for resistance. with default of 3 you can survive 100m drop no armor on half heart. 200m drop with enchanted armor easily",
                validate = {AmplifierLimit.class},
                category = {xpbeaconsCategory, RESISTANCE}
        )
        public static int resistance_amplitude_ceiling = 3;

        @Rule(
                desc="xp ceiling in levels for resistance",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, RESISTANCE}
        )
        public static int resistance_xp_ceiling = xpBeaconsMax;

        @Rule(
                desc="xp drain feature toggle for resistance",
                category = {xpbeaconsCategory, RESISTANCE}
        )
        public static boolean resistance_xp_drain = true;

        @Rule(
                desc="xp drain rate for resistance. each beacon tick takes away (haste_xp_drain_rate * effect amplifier) xp POINTS",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, RESISTANCE},
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
                desc="effect amplitude ceiling for resistance. default 5 is pretty fast, but if you have the default 8000 levels, is it really OP?",
                validate = {AmplifierLimit.class},
                category = {xpbeaconsCategory, REGENERATION}
        )
        public static int regeneration_amplitude_ceiling = 5;

        @Rule(
                desc="xp ceiling in levels for resistance",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, REGENERATION}
        )
        public static int regeneration_xp_ceiling = xpBeaconsMax;

        @Rule(
                desc="xp drain feature toggle for regeneration",
                category = {xpbeaconsCategory, REGENERATION}
        )
        public static boolean regeneration_xp_drain = true;

        @Rule(
                desc="xp drain rate for regeneration. each beacon tick takes away (haste_xp_drain_rate * effect amplifier) xp POINTS",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, REGENERATION},
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
                desc="xp drain rate for jump boost. each beacon tick takes away (haste_xp_drain_rate * effect amplifier) xp POINTS",
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

    public static class StrengthSettings extends EffectSettings {
        private static final String STRENGTH = "strength";
        public StrengthSettings() {
            EffectType = StatusEffects.STRENGTH;
        }

        @Rule(
                desc="toggle xp beacons for strength effect",
                category = {xpbeaconsCategory, STRENGTH}
        )
        public static boolean strength_xp_based_amplitude = true;

        @Rule(
                desc="effect amplitude ceiling for strength. one hit a zombie with your fists in this default.",
                validate = {AmplifierLimit.class},
                category = {xpbeaconsCategory, STRENGTH}
        )
        public static int strength_amplitude_ceiling = 4;

        @Rule(
                desc="xp ceiling in levels for strength",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, STRENGTH}
        )
        public static int strength_xp_ceiling = xpBeaconsMax;

        @Rule(
                desc="xp drain feature toggle for strength",
                category = {xpbeaconsCategory, STRENGTH}
        )
        public static boolean strength_xp_drain = true;

        @Rule(
                desc="xp drain rate for strength. each beacon tick takes away (haste_xp_drain_rate * effect amplifier) xp POINTS",
                validate = {Validator.NONNEGATIVE_NUMBER.class},
                category = {xpbeaconsCategory, STRENGTH},
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
}
