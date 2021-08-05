package net.fracturedcode.xpbeacons.mixins;

import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.ConstructBeaconCriterion;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// idk if this is actually necessary,
// but after I got the feature working i don't want to break it again
// because I'm too tired to deal with that rn
@Mixin(ConstructBeaconCriterion.class)
public abstract class ConstructBeaconCriterion_beaconLevelOverride extends AbstractCriterion<ConstructBeaconCriterion.Conditions> {

    @Inject(method="trigger", at = @At("HEAD"), cancellable = true)
    private void overrideMatches(ServerPlayerEntity player, int level, CallbackInfo ci) {
        this.trigger(player, (conditions) -> customPredicate(level));
        ci.cancel();
    }

    private boolean customPredicate(int level) {
        return level >= 0 && level <= XpBeaconsCategorySettings.BeaconSettings.beacon_max_pyramid_level;
    }
}
