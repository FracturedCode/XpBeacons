package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings;

import carpet.settings.Rule;
import carpet.settings.Validator;

public class BeaconSettings {
    public static final String beaconsCategory = "beacons";
    public static final String xpbeaconsCategory = "xpbeacons";
    // the default level ceiling of xp-based beacon status effects
    public static final int xpBeaconsMax = 8000;

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