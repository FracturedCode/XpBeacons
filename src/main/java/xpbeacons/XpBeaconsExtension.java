package xpbeacons;

import carpet.CarpetExtension;
import carpet.CarpetServer;

public class XpBeaconsExtension implements CarpetExtension {

    public static void noop() {}

    static {
        XpBeaconsExtension extension = new XpBeaconsExtension();
        CarpetServer.manageExtension(extension);
        extension.onGameStarted();
    }
    @Override
    public void onGameStarted() {
        CarpetServer.settingsManager.parseSettingsClass(XpBeaconsSimpleSettings.class);
    }
}