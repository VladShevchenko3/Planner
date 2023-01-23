package com.android.dayplanner.app.screens

import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickOn
import com.adevinta.android.barista.interaction.BaristaEditTextInteractions.clearText
import com.adevinta.android.barista.interaction.BaristaEditTextInteractions.typeTo
import com.adevinta.android.barista.interaction.BaristaKeyboardInteractions.closeKeyboard
import com.android.dayplanner.app.R

object CreateTaskScreen {

    private const val buttonSaveTask: Int = R.id.button_saveTask
    private const val editTextTitle: Int = R.id.editText_title
    private const val editTextDescription: Int = R.id.editText_description
    private const val editTextDate: Int = R.id.editText_taskDate
    private const val buttonCreateLongTempTask: Int = R.id.button_createLongTempTask
    private const val buttonCreateShortTempTask: Int = R.id.button_createShortTempTask

    fun actionEditTextTitle(textTitle: String) {
        clearText(editTextTitle)
        typeTo(editTextTitle, textTitle)
        closeKeyboard()
    }

    fun actionEditTextDescription(textDescription: String) {
        clearText(editTextDescription)
        typeTo(editTextDescription, textDescription)
        closeKeyboard()
    }

    fun actionEditTextDate(textData: String) {
        clearText(editTextDate)
        typeTo(editTextDate, textData)
        closeKeyboard()
    }

    fun actionClickOnSaveButton() {
        clickOn(buttonSaveTask)
    }

    fun actionClickOnCreateLongTempTaskButton() {
        clickOn(buttonCreateLongTempTask)
    }

    fun actionClickOnCreateShortTempTaskButton() {
        clickOn(buttonCreateShortTempTask)
    }
}