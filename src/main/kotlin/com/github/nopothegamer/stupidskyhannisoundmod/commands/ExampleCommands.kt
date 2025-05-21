package com.github.nopothegamer.stupidskyhannisoundmod.commands

import at.hannibal2.skyhanni.SkyHanniMod
import at.hannibal2.skyhanni.api.event.HandleEvent
import at.hannibal2.skyhanni.config.commands.CommandBuilder
import at.hannibal2.skyhanni.config.commands.CommandCategory
import at.hannibal2.skyhanni.data.GuiEditManager
import at.hannibal2.skyhanni.deps.moulconfig.gui.GuiScreenElementWrapper
import com.github.nopothegamer.stupidskyhannisoundmod.stupid-skyhanni-sound-mod
import com.github.nopothegamer.stupidskyhannisoundmod.events.ExampleCommandRegistrationEvent
import com.github.nopothegamer.stupidskyhannisoundmod.modules.Module

@Module
object ExampleCommands {

    private fun getOpenMainMenu(args: Array<String>) {
        if (args.isNotEmpty()) {
            if (args[0].lowercase() == "gui") {
                GuiEditManager.openGuiPositionEditor(hotkeyReminder = true)
            } else openConfigGui(args.joinToString(" "))
        } else openConfigGui()
    }

    val commandsList = mutableListOf<CommandBuilder>()

    @HandleEvent
    fun onCommandRegistration(event: ExampleCommandRegistrationEvent) {
        event.register("stupidskyhannisoundmod") {
            this.aliases = listOf("stupidskyhannisoundmodconfig")
            this.category = CommandCategory.MAIN
            this.description = "Opens the main ${stupid-skyhanni-sound-mod.MOD_NAME} config"
            callback(::getOpenMainMenu)
        }
        event.register("stupidskyhannisoundmodcommands") {
            this.description = "Shows this list"
            this.category = CommandCategory.MAIN
            callback(ExampleHelpCommand::onCommand)
        }
        event.register("stupidskyhannisoundmodsaveconfig") {
            this.description = "Saves the config"
            this.category = CommandCategory.DEVELOPER_TEST
            callback { stupid-skyhanni-sound-mod.managedConfig.saveToFile() }
        }
    }

    private fun openConfigGui(search: String? = null) {
        val editor = stupid-skyhanni-sound-mod.managedConfig.getEditor()

        search?.let { editor.search(search) }
        SkyHanniMod.screenToOpen = GuiScreenElementWrapper(editor)
    }
}
