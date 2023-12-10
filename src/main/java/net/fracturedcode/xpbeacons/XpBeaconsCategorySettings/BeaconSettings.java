package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings;

import carpet.api.settings.Rule;
import carpet.api.settings.Validators;

public class BeaconSettings {
    public static final String beaconsCategory = "general_beacon_settings";
    public static final String xpbeaconsCategory = "xpbeacons";
    // the default level ceiling of xp-based beacon status effects
    public static final int xpBeaconsMax = 8000;

    @Rule(
            categories = {xpbeaconsCategory, beaconsCategory},
            validators = {Validators.NonNegativeNumber.class},
            strict = false
    )
    public static int beacon_tick_rate = 80;

    @Rule(
            categories = {xpbeaconsCategory, beaconsCategory},
            validators = {Validators.NonNegativeNumber.class},
            strict = false
    )
    public static int beacon_max_pyramid_level = 4;

    @Rule(
            categories = {xpbeaconsCategory, beaconsCategory},
            validators = {Validators.NonNegativeNumber.class},
            strict = false
    )
    public static int beacon_reach_multiplier = 10;

    @Rule(
            categories = {xpbeaconsCategory, beaconsCategory},
            validators = {Validators.NonNegativeNumber.class},
            strict = false
    )
    public static int beacon_duration_multiplier = 2;
}