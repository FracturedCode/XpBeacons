package net.fracturedcode.xpbeacons;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.api.settings.SettingsManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings.*;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

public class XpBeaconsExtension implements CarpetExtension {
    private final static SettingsManager customSettingsManager;
    public static void noop() {}

    static {
        CarpetServer.manageExtension(new XpBeaconsExtension());
        customSettingsManager = new SettingsManager("7.4", "xpbeacons", "Experience Beacons");//VERSION
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

    public Map<String, String> canHasTranslations(String lang) {
        InputStream langFile = XpBeaconsExtension.class.getResourceAsStream("/assets/xpbeacons/lang/%s.json".formatted(lang));
        if (langFile == null) {
            // we don't have that language
            return Collections.emptyMap();
        }
        String jsonData;
        try {
            jsonData = IOUtils.toString(langFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return Collections.emptyMap();
        }
        Gson gson = new GsonBuilder().setLenient().create(); // lenient allows for comments
        return gson.fromJson(jsonData, new TypeToken<Map<String, String>>() {}.getType());
    }
}