package com.github.nopothegamer.stupidskyhannisoundmod.mixins.transformers;

import com.github.nopothegamer.stupidskyhannisoundmod.stupid-skyhanni-sound-mod;
import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(GuiMainMenu.class)
public class MixinGuiMainMenu {

    @Inject(method = "initGui", at = @At("HEAD"))
    public void onInitGui(CallbackInfo ci) {
        stupid-skyhanni-sound-mod.logger.info("Hello from Main Menu!");
    }
}
