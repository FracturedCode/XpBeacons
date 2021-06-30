package xpbeacons.mixins;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xpbeacons.XpBeaconsCategorySettings;
import xpbeacons.XpBeaconsSimpleSettings;

import java.util.function.Predicate;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconBlockEntity_xpBeaconTileMixin extends BlockEntity {

    public BeaconBlockEntity_xpBeaconTileMixin(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
        super(type, blockPos, blockState);
    }

    @Inject(method="applyPlayerEffects", at=@At("RETURN"))
    private static void applyXpBasedStatusEffects(World world, BlockPos pos, int beaconLevel, @Nullable StatusEffect primaryEffect, @Nullable StatusEffect secondaryEffect, CallbackInfo ci) {

        if (XpBeaconsSimpleSettings.xpBeacons && primaryEffect != null && !world.isClient) {
            int r = (int)Math.pow(2, beaconLevel + 3);
            int x1 = pos.getX() - r, x2 = pos.getX() + r,
                    z1 = pos.getZ() - r, z2 = pos.getZ() + r,
                    y1 = Math.max(pos.getY() - r, 0), y2 = Math.min(pos.getY() + r, world.getHeight());
            Box range = new Box(x1, y1, z1, x2, y2, z2);

            double statusMultiplier = getEffectSpecificAmplificationMultiplier(primaryEffect, primaryEffect);

            if (secondaryEffect == null) {
                statusMultiplier /= 2; // Use the secondary to unlock FULL POWA
            } else if (secondaryEffect.equals(StatusEffects.REGENERATION)) {
                statusMultiplier /= 2;  // If secondary is regen apply xp-based regen
                applyEffectToAllPlayers(world, secondaryEffect, range, getEffectSpecificAmplificationMultiplier(primaryEffect, secondaryEffect));
            }

            applyEffectToAllPlayers(world, primaryEffect, range, statusMultiplier);
        }
    }
    private static double getEffectSpecificAmplificationMultiplier(@Nullable StatusEffect primaryEffect, StatusEffect se) {
        double statusMultiplier = 0.0;
        double[] multipliersInOrder = // UGGGGG JAVA WON"T DO SWITCHES ON OBJECTS
                {
                        XpBeaconsCategorySettings.hasteMultiplier,
                        XpBeaconsCategorySettings.speedMultiplier,
                        XpBeaconsCategorySettings.resistanceMultiplier,
                        XpBeaconsCategorySettings.regenMultiplier,
                        XpBeaconsCategorySettings.jumpMultiplier,
                        XpBeaconsCategorySettings.strengthMultiplier
                };
        StatusEffect[] effectsInOrder =
                {
                        StatusEffects.HASTE,
                        StatusEffects.SPEED,
                        StatusEffects.RESISTANCE,
                        StatusEffects.REGENERATION,
                        StatusEffects.JUMP_BOOST,
                        StatusEffects.STRENGTH
                };
        for (int i = 0; i<effectsInOrder.length; i++) {
            if (effectsInOrder[i].equals(primaryEffect)) {
                statusMultiplier = multipliersInOrder[i];
                break;
            }
        }
        return statusMultiplier;
    }
    private static void applyEffectToAllPlayers(World world, StatusEffect se, Box range, double statusMultiplier) {
        for (PlayerEntity player : world.getEntitiesByClass(PlayerEntity.class, range, x -> true)) {
            int amplifier = (int)(Math.min((int)((double)player.experienceLevel / XpBeaconsCategorySettings.xpBeaconsMax * 255), 255) * statusMultiplier);
            player.addStatusEffect(new StatusEffectInstance(se, 400, amplifier, true, true));
        }
    }
}