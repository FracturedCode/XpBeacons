package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings;

import carpet.api.settings.CarpetRule;
import carpet.api.settings.Validator;
import net.minecraft.server.command.ServerCommandSource;

public class AmplifierLimit extends Validator<Integer> {
    @Override
    public Integer validate(ServerCommandSource source, CarpetRule<Integer> currentRule, Integer newValue, String string) {
        return (newValue >= 0 && newValue <= 255) ? newValue : null;
    }
    @Override
    public String description() { return "You must choose a value from 0 to 255"; }
}