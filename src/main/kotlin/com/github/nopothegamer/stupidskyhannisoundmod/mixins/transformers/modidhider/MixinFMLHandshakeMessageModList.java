package com.github.nopothegamer.stupidskyhannisoundmod.mixins.transformers.modidhider;

import com.github.nopothegamer.stupidskyhannisoundmod.stupid-skyhanni-sound-mod;
import net.minecraftforge.fml.common.network.handshake.FMLHandshakeMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;


@Mixin(FMLHandshakeMessage.ModList.class)
public abstract class MixinFMLHandshakeMessageModList {

    @Shadow
    public abstract Map<String, String> modList();

    @Inject(method = "<init>(Ljava/util/List;)V", at = @At(value = "RETURN"))
    public void onInitLast(List modList, CallbackInfo ci) {
        if (!stupid-skyhanni-sound-mod.HIDE_MOD_ID) return;
        modList().remove(stupid-skyhanni-sound-mod.MOD_ID);
    }
}
