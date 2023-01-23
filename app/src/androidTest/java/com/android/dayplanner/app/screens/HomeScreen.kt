package com.android.dayplanner.app.screens

import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickOn
import com.adevinta.android.barista.interaction.BaristaMenuClickInteractions.openMenu
import com.android.dayplanner.app.R

object HomeScreen : ListOfTasksBasic {

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

    fun assertTaskIsNotPresentOnScreen(title: String) {
        // assertTaskIsNotInTheList(listOfTasksView, title)
    }

    fun assertTasksListIsEmpty() {
        //assertTheListSize(listOfTasksView, 0)
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

    fun assertTheStatusOfTaskIsNotChecked(textTitle: String) {
       // assertTheStatusIsNotChecked(listOfTasksView, textTitle)
    }
}