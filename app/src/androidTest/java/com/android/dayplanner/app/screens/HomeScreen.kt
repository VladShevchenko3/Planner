package com.android.dayplanner.app.screens

import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickOn
import com.adevinta.android.barista.interaction.BaristaMenuClickInteractions.openMenu
import com.android.dayplanner.app.R
import com.android.dayplanner.app.screens.ListOfTasksBasic.actionClickOnDeleteButtonAtPosition
import com.android.dayplanner.app.screens.ListOfTasksBasic.actionClickOnTheCheckBoxAtPosition
import com.android.dayplanner.app.screens.ListOfTasksBasic.actionClickOnTheTaskAtPosition
import com.android.dayplanner.app.screens.ListOfTasksBasic.assertDisplayedDateAtPosition
import com.android.dayplanner.app.screens.ListOfTasksBasic.assertDisplayedDescriptionAtPosition
import com.android.dayplanner.app.screens.ListOfTasksBasic.assertDisplayedTitleAtPosition
import com.android.dayplanner.app.screens.ListOfTasksBasic.assertListItemCount
import com.android.dayplanner.app.screens.ListOfTasksBasic.assertTheStatusIsNotCheckedAtPosition

object HomeScreen  {

    private const val fabTaskButton: Int = R.id.floating_action_button
    private const val showHistory: Int = R.string.label_history
    private const val deleteAllTask: Int = R.string.label_delete_all
    private const val yesView: Int = R.string.yes
    private const val listOfTasks: Int = R.id.recyclerView

    fun actionClickOnFabTaskButton() {
        clickOn(fabTaskButton)
    }

    fun actionDeleteTheTaskAtPosition(elementPosition: Int) {
        actionClickOnDeleteButtonAtPosition(listOfTasks, elementPosition)
    }

    fun actionEditTheTaskAtPosition(elementPosition: Int) {
        actionClickOnTheTaskAtPosition(listOfTasks, elementPosition)
    }

    fun actionClickOnCompleteTheTaskAtPosition(elementPosition: Int) {
        actionClickOnTheCheckBoxAtPosition(listOfTasks, elementPosition)
    }

    fun actionOpenMenu() {
        openMenu()
    }

    fun actionClickOnTheDeleteAllTasks() {
        clickOn(deleteAllTask)
    }

    fun actionClickOnYesButton() {
        clickOn(yesView)
    }

    fun actionClickOnTheTasksHistory() {
        clickOn(showHistory)
    }

    fun assertTasksListIsEmpty() {
        assertListItemCount(listOfTasks, 0)
    }

    fun assertDisplayedTaskTitleAtPosition(elementPosition: Int, textTitle: String) {
        assertDisplayedTitleAtPosition(listOfTasks, elementPosition, textTitle)
    }

    fun assertDisplayedTaskDescriptionAtPosition(elementPosition: Int, textDescription: String) {
        assertDisplayedDescriptionAtPosition(listOfTasks, elementPosition, textDescription)
    }

    fun assertDisplayedTaskDateAtPosition(elementPosition: Int, textDate: String) {
        assertDisplayedDateAtPosition(listOfTasks, elementPosition, textDate)
    }

    fun assertTheStatusOfTaskIsNotCheckedAtPosition(elementPosition: Int) {
        assertTheStatusIsNotCheckedAtPosition(listOfTasks, elementPosition)
    }
}