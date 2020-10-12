package xpbeacons.mixins;

import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xpbeacons.XpBeaconsSimpleSettings;

import java.util.List;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconBlockEntity_xpBeaconTileMixin extends BlockEntity {

    @Shadow private StatusEffect primary;

    public BeaconBlockEntity_xpBeaconTileMixin(BlockEntityType<?> type) {
        super(type);
    }

    @Inject(method="applyPlayerEffects", at = @At("HEAD"))
    private void applyXpBasedStatusEffects(CallbackInfo callbackInfo) {
        if (XpBeaconsSimpleSettings.xpBeacons) {
            List<PlayerEntity> playersInRange = this.world.getEntitiesByClass(PlayerEntity.class, new Box(-20, 0, -20, 20, 0, 20), null);
            for (PlayerEntity player : playersInRange) {
                player.applyStatusEffect(new StatusEffectInstance(this.primary, 10, 10, true, true));
            }
        }
        return;
    }
}
