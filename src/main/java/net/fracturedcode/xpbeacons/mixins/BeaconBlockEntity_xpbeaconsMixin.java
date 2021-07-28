package net.fracturedcode.xpbeacons.mixins;

import net.fracturedcode.xpbeacons.EffectSettings;
import net.fracturedcode.xpbeacons.XpBeaconsCategorySettings;
import net.fracturedcode.xpbeacons.XpBeaconsSimpleSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import java.util.Arrays;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconBlockEntity_xpbeaconsMixin extends BlockEntity {
    public BeaconBlockEntity_xpbeaconsMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    private static final EffectSettings[] effectsSettings = new EffectSettings[] {
            new XpBeaconsCategorySettings.StrengthSettings(),
            new XpBeaconsCategorySettings.HasteSettings(),
            new XpBeaconsCategorySettings.SpeedSettings(),
            new XpBeaconsCategorySettings.ResistanceSettings(),
            new XpBeaconsCategorySettings.RegenerationSettings(),
            new XpBeaconsCategorySettings.JumpBoostSettings()
    };

    @ModifyVariable(method="applyPlayerEffects", at = @At("STORE"), ordinal = 0)
    private static double customBeaconRadius(double calculated) {
        if (XpBeaconsCategorySettings.BeaconRadiusSettings.beacon_radius_modified) {
            return switch ((int) calculated) {
                case 20 -> XpBeaconsCategorySettings.BeaconRadiusSettings.beacon_radius_level_one;
                case 30 -> XpBeaconsCategorySettings.BeaconRadiusSettings.beacon_radius_level_two;
                case 40 -> XpBeaconsCategorySettings.BeaconRadiusSettings.beacon_radius_level_three;
                case 50 -> XpBeaconsCategorySettings.BeaconRadiusSettings.beacon_radius_level_four;
                default -> throw new RuntimeException("Impossible beacon radius state for vanilla");
            };
        } else {
            return calculated;
        }
    }

    @Redirect(method = "applyPlayerEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;)Z"))
    private static boolean applyXpBasedEffects(PlayerEntity player, StatusEffectInstance effect) {
        StatusEffect effectType = effect.getEffectType();

        if (XpBeaconsSimpleSettings.xpbeacons) {
            EffectSettings effectSettings = Arrays.stream(effectsSettings).filter(es -> es.getEffect() == effectType).findFirst().get();
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
}