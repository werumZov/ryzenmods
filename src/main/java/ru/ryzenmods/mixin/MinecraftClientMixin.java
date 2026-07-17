package ru.ryzenmods.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.ryzenmods.RyzenMods;
import ru.ryzenmods.client.util.MCUtil;

@Environment(EnvType.CLIENT)
@Mixin({MinecraftClient.class})
public class MinecraftClientMixin implements MCUtil {
    private static boolean initialized = false;

    @Shadow
    private int itemUseCooldown;

    @Inject(
            method = {"tick"},
            at = {@At("HEAD")}
    )
    public void onTick(CallbackInfo ci) {
       // if (!initialized) {
       //     return;
       // }
        RyzenMods.onTick();
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void disableItemUseCooldown(CallbackInfo ci) {
       // this.itemUseCooldown = 0;

    }
}
