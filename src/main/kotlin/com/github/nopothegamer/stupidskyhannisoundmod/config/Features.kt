package com.github.nopothegamer.stupidskyhannisoundmod.config

import at.hannibal2.skyhanni.deps.moulconfig.Config
import at.hannibal2.skyhanni.deps.moulconfig.annotations.Category
import com.github.nopothegamer.stupidskyhannisoundmod.stupid-skyhanni-sound-mod
import com.github.nopothegamer.stupidskyhannisoundmod.stupid-skyhanni-sound-mod.managedConfig

class Features : Config() {
    override fun shouldAutoFocusSearchbar(): Boolean = true

    override fun getTitle(): String = "${stupid-skyhanni-sound-mod.MOD_NAME} ${stupid-skyhanni-sound-mod.VERSION}"

    override fun saveNow() = managedConfig.saveToFile()

    @Category(name = "Example", desc = "")
    var exampleCategory: ExampleCategory = ExampleCategory()
}
