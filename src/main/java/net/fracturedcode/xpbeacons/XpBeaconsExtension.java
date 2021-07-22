package net.fracturedcode.xpbeacons;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.settings.SettingsManager;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;

public class XpBeaconsExtension implements CarpetExtension {
    private final static SettingsManager customSettingsManager;
    public static void noop() {}

    static {
        CarpetServer.manageExtension(new XpBeaconsExtension());
        customSettingsManager = new SettingsManager("3.0", "xpbeacons", "Experience Beacons");
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