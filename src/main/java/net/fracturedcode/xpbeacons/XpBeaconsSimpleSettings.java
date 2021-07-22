package net.fracturedcode.xpbeacons;

import carpet.settings.Rule;
import carpet.settings.Validator;
import static carpet.settings.RuleCategory.FEATURE;

public class XpBeaconsSimpleSettings {
    private static final String xpBeaconsCategory = "xpbeacons";

    @Rule(desc="if true uses experience-based amplitude on beacon status effects. See xp.fracturedcode.net", category = {xpBeaconsCategory, FEATURE})
    public static boolean xpbeacons = false;
}
