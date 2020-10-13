package xpbeacons.mixins;

import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xpbeacons.XpBeaconsSimpleSettings;
import net.minecraft.util.math.BlockBox;

import java.util.List;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconBlockEntity_xpBeaconTileMixin extends BlockEntity {

    @Shadow private StatusEffect primary;

    @Shadow private int level;

    public BeaconBlockEntity_xpBeaconTileMixin(BlockEntityType<?> type) {
        super(type);
    }

    @Inject(method="applyPlayerEffects", at=@At("RETURN"))
    private void applyXpBasedStatusEffects(CallbackInfo ci) {

        if (XpBeaconsSimpleSettings.xpBeacons && this.primary != null) {
            int r = (int)Math.pow(2, this.level);
            int x1 = this.pos.getX() - r, x2 = this.pos.getX() + r,
                    z1 = this.pos.getZ() - r, z2 = this.pos.getZ() + r,
                    y1 = Math.max(this.pos.getY() - r, 0), y2 = Math.min(this.pos.getY() + r, this.world.getHeight());
            Box range = new Box(x1, y1, z1, x2, y2, z2);

            double statusMultiplier = 0.0;
            double[] multipliersInOrder = // UGGGGG JAVA WON"T DO SWITCHES ON OBJECTS
            {
                .1, 1.0, .2, .03, .001, .5
            };
            StatusEffect[] effectsInOrder =
            {
                StatusEffects.HASTE,
                StatusEffects.SPEED,
                StatusEffects.RESISTANCE,
                StatusEffects.REGENERATION,
                StatusEffects.JUMP_BOOST,
                StatusEffects.STRENGTH,
            };
            for (int i = 0; i<effectsInOrder.length; i++) {
                if (effectsInOrder[i].equals(this.primary)) {
                    statusMultiplier = multipliersInOrder[i];
                    break;
                }
            }

            for (PlayerEntity player : this.world.getEntitiesByClass(PlayerEntity.class, range, null)) {
                int amplifier = (int)(Math.min((int)((double)player.experienceLevel / XpBeaconsSimpleSettings.xpBeaconMax * 255), 255) * statusMultiplier);
                player.addStatusEffect(new StatusEffectInstance(this.primary, 400, amplifier, true, true));
            }
        }
    }
}