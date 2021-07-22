package net.fracturedcode.xpbeacons.mixins;

import net.minecraft.util.crash.CrashReport;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.fracturedcode.xpbeacons.XpBeaconsExtension;

@Mixin(CrashReport.class)
public class CrashReport_noopMixin {
    @Inject(method = "initCrashReport", at = @At("HEAD"))
    private static void loadXpExtension(CallbackInfo ci) {
        XpBeaconsExtension.noop();
    }
}
