package net.fracturedcode.xpbeacons;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.settings.SettingsManager;

public class XpBeaconsExtension implements CarpetExtension {
    private final static SettingsManager customSettingsManager;
    public static void noop() {}

    static {
        CarpetServer.manageExtension(new XpBeaconsExtension());
        customSettingsManager = new SettingsManager("7.0", "xpbeacons", "Experience Beacons");//VERSION
    }
    @Override
    public void onGameStarted() {
        CarpetServer.settingsManager.parseSettingsClass(XpBeaconsSimpleSettings.class);

        customSettingsManager.parseSettingsClass(XpBeaconsCategorySettings.HasteSettings.class);
        customSettingsManager.parseSettingsClass(XpBeaconsCategorySettings.SpeedSettings.class);
        customSettingsManager.parseSettingsClass(XpBeaconsCategorySettings.RegenerationSettings.class);
        customSettingsManager.parseSettingsClass(XpBeaconsCategorySettings.ResistanceSettings.class);
        customSettingsManager.parseSettingsClass(XpBeaconsCategorySettings.JumpBoostSettings.class);
        customSettingsManager.parseSettingsClass(XpBeaconsCategorySettings.StrengthSettings.class);

        customSettingsManager.parseSettingsClass(XpBeaconsCategorySettings.BeaconRadiusSettings.class);
        customSettingsManager.parseSettingsClass(XpBeaconsCategorySettings.BeaconSettings.class);
    }

    @Override
    public SettingsManager customSettingsManager() {
        return customSettingsManager;
    }
}