package xpbeacons.mixins;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xpbeacons.XpBeaconsExtension;

@Mixin(MinecraftClient.class)
public class MinecraftClient_noopMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void loadExtension(CallbackInfo ci) {
        XpBeaconsExtension.noop();
    }
}
