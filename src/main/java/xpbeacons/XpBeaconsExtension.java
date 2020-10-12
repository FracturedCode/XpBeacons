package xpbeacons;

import carpet.CarpetExtension;
import carpet.CarpetServer;

public class XpBeaconsExtension implements CarpetExtension {
    static {
        CarpetServer.manageExtension(new XpBeaconsExtension());
    }
    @Override
    public void onGameStarted() {
        CarpetServer.settingsManager.parseSettingsClass(XpBeaconsSimpleSettings.class);
    }
}