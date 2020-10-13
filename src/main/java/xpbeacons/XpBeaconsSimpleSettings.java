package xpbeacons;

import carpet.settings.Rule;
import carpet.settings.Validator;
import static carpet.settings.RuleCategory.FEATURE;

public class XpBeaconsSimpleSettings {
    private static final String xpBeaconsCategory = "xpbeacons";
    @Rule(desc="if true uses experience-based amplitude on beacon status effects", category = {xpBeaconsCategory, FEATURE})
    public static boolean xpBeacons = true;

    @Rule(
            desc = "the level ceiling of xp-based beacon status effects, default 8000",
            validate = {Validator.NONNEGATIVE_NUMBER.class},
            category = {xpBeaconsCategory, FEATURE}
    )
    public static int xpBeaconsMax = 8000;
}
