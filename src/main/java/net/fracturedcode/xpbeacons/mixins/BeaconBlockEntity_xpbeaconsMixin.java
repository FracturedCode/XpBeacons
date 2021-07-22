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

    @Redirect(method = "applyPlayerEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;)Z"))
    private static boolean applyXpBasedEffects(PlayerEntity player, StatusEffectInstance oldEffect) {
        StatusEffect effectType = oldEffect.getEffectType();
        EffectSettings effectSettings = Arrays.stream(effectsSettings).filter(es -> es.getEffect() == effectType).findFirst().get();

        if (XpBeaconsSimpleSettings.xpbeacons && effectSettings.getModdedBehaviorToggle()) {

            int amplifier = (int)(effectSettings.getEffectAmplitudeCeiling() * ((double)Math.min(player.experienceLevel, effectSettings.getEffectXpCeiling()) / effectSettings.getEffectXpCeiling()));

            StatusEffectInstance newEffect = new StatusEffectInstance(
                    effectType,
                    oldEffect.getDuration(),
                    amplifier,
                    oldEffect.isAmbient(),
                    oldEffect.shouldShowParticles(),
                    oldEffect.shouldShowIcon()
            );
            return player.addStatusEffect(newEffect);
        } else {
            return player.addStatusEffect(oldEffect);
        }
    }
}