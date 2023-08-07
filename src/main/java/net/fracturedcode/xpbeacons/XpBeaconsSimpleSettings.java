package net.fracturedcode.xpbeacons;

import carpet.api.settings.Rule;
import static carpet.api.settings.RuleCategory.FEATURE;

public class XpBeaconsSimpleSettings {
    private static final String xpBeaconsCategory = "xpbeacons";

    @Rule(categories = {xpBeaconsCategory, FEATURE})
    public static boolean xpbeacons = false;
}
