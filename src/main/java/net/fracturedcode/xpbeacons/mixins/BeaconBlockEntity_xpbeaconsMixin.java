package net.fracturedcode.xpbeacons.mixins;

import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.BeaconSettings;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings.*;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings.EffectSettings.StrengthSettings;
import net.fracturedcode.xpbeacons.XpBeaconsSimpleSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import java.util.Arrays;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconBlockEntity_xpbeaconsMixin extends BlockEntity {
    public BeaconBlockEntity_xpbeaconsMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    private static final AbstractEffectSettings[] effectsSettings = new AbstractEffectSettings[] {
            new StrengthSettings(),
            new HasteSettings(),
            new SpeedSettings(),
            new ResistanceSettings(),
            new RegenerationSettings(),
            new JumpBoostSettings()
    };

    @ModifyConstant(method="applyPlayerEffects", constant = @Constant(intValue = 10, ordinal = 0))
    private static int customReachMultiplier(int value) {
        return BeaconSettings.beacon_reach_multiplier;
    }

    @Redirect(method = "applyPlayerEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;)Z"))
    private static boolean applyXpBasedEffects(PlayerEntity player, StatusEffectInstance effect) {
        StatusEffect effectType = effect.getEffectType();

        if (XpBeaconsSimpleSettings.xpbeacons) {
            AbstractEffectSettings effectSettings = Arrays.stream(effectsSettings).filter(es -> es.getEffect() == effectType).findFirst().get();
            int amplifier = effect.getAmplifier();

            if (effectSettings.getXpAmplitudeToggle()) {

                amplifier = (int)(effectSettings.getEffectAmplitudeCeiling() * ((double)Math.min(player.experienceLevel, effectSettings.getEffectXpCeiling()) / effectSettings.getEffectXpCeiling()));

                effect = new StatusEffectInstance(
                        effectType,
                        effect.getDuration(),
                        amplifier == 0 ? 1 : amplifier,
                        effect.isAmbient(),
                        effect.shouldShowParticles(),
                        effect.shouldShowIcon()
                );
            }

            if (effectSettings.getShouldDrainXp()) {
                player.addExperience(-amplifier * effectSettings.getXpDrainRate());
            }
        }
        return player.addStatusEffect(effect);
    }

    @Redirect(method="tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getTime()J"))
    private static long customBeaconTickRate(World world) {
        return XpBeaconsSimpleSettings.xpbeacons ?
                (world.getTime() % BeaconSettings.beacon_tick_rate == 0 ? 80L : 1L)
                : world.getTime();
    }

    @ModifyConstant(method="updateLevel", constant = @Constant(intValue = 4))
    private static int modifyMaxBeaconLevel(int maxLevel) {
        return XpBeaconsSimpleSettings.xpbeacons ? BeaconSettings.beacon_max_pyramid_level : maxLevel;
    }

    @ModifyConstant(method="applyPlayerEffects", constant = @Constant(intValue = 2))
    private static int modifyDurationMultiplier(int unmodified) {
        return XpBeaconsSimpleSettings.xpbeacons ? BeaconSettings.beacon_duration_multiplier : unmodified;
    }
}