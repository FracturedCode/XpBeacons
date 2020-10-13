package xpbeacons;

import carpet.settings.Rule;
import carpet.settings.Validator;

import static carpet.settings.RuleCategory.FEATURE;

public class XpBeaconsCategorySettings {
    private static final String xpBeaconsCategory = "xpbeacons";
    @Rule(
            desc = "the level ceiling of xp-based beacon status effects, default 8000",
            validate = {Validator.NONNEGATIVE_NUMBER.class},
            category = {xpBeaconsCategory}
    )
    public static int xpBeaconsMax = 8000;

    @Rule(desc="effect multiplier for haste", validate = {Validator.PROBABILITY.class}, category = {xpBeaconsCategory})
    public static double hasteMultiplier = .3;

    @Rule(desc="effect multiplier for speed", validate = {Validator.PROBABILITY.class}, category = {xpBeaconsCategory})
    public static double speedMultiplier = .039;

    @Rule(desc="effect multiplier for resistance", validate = {Validator.PROBABILITY.class}, category = {xpBeaconsCategory})
    public static double resistanceMultiplier = .02;

    @Rule(desc="effect multiplier for regeneration", validate = {Validator.PROBABILITY.class}, category = {xpBeaconsCategory})
    public static double regenMultiplier = .0157;

    @Rule(desc="effect multiplier for jump boost", validate = {Validator.PROBABILITY.class}, category = {xpBeaconsCategory})
    public static double jumpMultiplier = .009;

    @Rule(desc="effect multiplier for strength", validate = {Validator.PROBABILITY.class}, category = {xpBeaconsCategory})
    public static double strengthMultiplier = .2;
}
