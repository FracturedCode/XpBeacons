package net.fracturedcode.xpbeacons;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.settings.SettingsManager;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings.*;

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

        customSettingsManager.parseSettingsClass(HasteSettings.class);
        customSettingsManager.parseSettingsClass(SpeedSettings.class);
        customSettingsManager.parseSettingsClass(RegenerationSettings.class);
        customSettingsManager.parseSettingsClass(ResistanceSettings.class);
        customSettingsManager.parseSettingsClass(JumpBoostSettings.class);
        customSettingsManager.parseSettingsClass(StrengthSettings.class);

        customSettingsManager.parseSettingsClass(BeaconSettings.class);
    }

    @Override
    public SettingsManager customSettingsManager() {
        return customSettingsManager;
    }
}