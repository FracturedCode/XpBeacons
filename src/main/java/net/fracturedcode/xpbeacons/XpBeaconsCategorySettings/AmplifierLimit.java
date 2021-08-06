package net.fracturedcode.xpbeacons.XpBeaconsCategorySettings;

import carpet.settings.ParsedRule;
import carpet.settings.Validator;
import net.minecraft.server.command.ServerCommandSource;

public class AmplifierLimit extends Validator<Integer> {
    @Override
    public Integer validate(ServerCommandSource source, ParsedRule<Integer> currentRule, Integer newValue, String string) {
        return (newValue >= 0 && newValue <= 255) ? newValue : null;
    }
    @Override
    public String description() { return "You must choose a value from 0 to 255"; }
}