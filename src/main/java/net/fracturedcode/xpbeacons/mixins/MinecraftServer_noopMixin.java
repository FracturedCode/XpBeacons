package xpbeacons.mixins;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xpbeacons.XpBeaconsExtension;

@Mixin(MinecraftServer.class)
public class MinecraftServer_noopMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void loadXpExtension(CallbackInfo ci) {
        XpBeaconsExtension.noop();
    }
}
