package xpbeacons;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.settings.SettingsManager;

public class XpBeaconsExtension implements CarpetExtension {
    private final static SettingsManager customSettingsManager;
    public static void noop() {}

    static {
        XpBeaconsExtension extension = new XpBeaconsExtension();
        CarpetServer.manageExtension(extension);
        customSettingsManager = new SettingsManager("2.0-SNAPSHOT", "xpBeaconsSettings", "Experience Beacons");
        extension.onGameStarted();
    }
    @Override
    public void onGameStarted() {
        CarpetServer.settingsManager.parseSettingsClass(XpBeaconsSimpleSettings.class);
        customSettingsManager.parseSettingsClass(XpBeaconsCategorySettings.class);
    }
    @Override
    public SettingsManager customSettingsManager() {
        return customSettingsManager;
    }
}