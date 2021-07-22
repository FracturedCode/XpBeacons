package net.fracturedcode.xpbeacons.mixins;

import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconBlockEntity_xpbeaconsMixin extends BlockEntity {
    public BeaconBlockEntity_xpbeaconsMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Redirect(method = "applyPlayerEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;)Z"))
    private static boolean applyXpBasedEffects(PlayerEntity player, StatusEffectInstance oldEffect) {

        StatusEffect effectType = oldEffect.getEffectType();
        Map<StatusEffect, Double> effectMultiplierMap = Map.of(
                StatusEffects.HASTE, XpBeaconsCategorySettings.hasteMultiplier,
                StatusEffects.SPEED, XpBeaconsCategorySettings.speedMultiplier,
                StatusEffects.RESISTANCE, XpBeaconsCategorySettings.resistanceMultiplier,
                StatusEffects.REGENERATION, XpBeaconsCategorySettings.regenMultiplier,
                StatusEffects.JUMP_BOOST, XpBeaconsCategorySettings.jumpMultiplier,
                StatusEffects.STRENGTH, XpBeaconsCategorySettings.strengthMultiplier
        );
        double amplifierMultiplier = effectMultiplierMap.get(effectType);
        int amplifier = (int)(Math.min((int)((double)(((PlayerEntity)player).experienceLevel) / XpBeaconsCategorySettings.xpBeaconsMax * 255), 255) * amplifierMultiplier);

        StatusEffectInstance newEffect = new StatusEffectInstance(
                effectType,
                oldEffect.getDuration(),
                amplifier, oldEffect.isAmbient(),
                oldEffect.shouldShowParticles(),
                oldEffect.shouldShowIcon()
        );
        return player.addStatusEffect(newEffect);
    }
}
