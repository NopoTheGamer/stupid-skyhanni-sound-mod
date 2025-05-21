package com.github.nopothegamer.stupidskyhannisoundmod.features.misc

import at.hannibal2.skyhanni.api.event.HandleEvent
import at.hannibal2.skyhanni.events.GuiRenderEvent
import at.hannibal2.skyhanni.utils.RenderUtils.renderString
import com.github.nopothegamer.stupidskyhannisoundmod.stupid-skyhanni-sound-mod
import com.github.nopothegamer.stupidskyhannisoundmod.modules.Module

@Module
object ExampleFeature {

    private val config get() = stupid-skyhanni-sound-mod.feature.exampleCategory

    @HandleEvent
    fun onRenderOverlay(event: GuiRenderEvent.GuiOverlayRenderEvent) {
        if (!config.exampleOption) return
        config.position.renderString("Hi, this is a test feature", posLabel = "Example Option")
    }

}
