package com.android.dayplanner.app.screens

import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickBack
import com.android.dayplanner.app.R

object HistoryScreen: ListOfTasksBasic {

    private const val listOfCompetedTasks: Int = R.id.recyclerView

    fun actionUncheckTheTaskStatusAtPosition(elementPosition: Int) {
        actionClickOnTheCheckBoxAtPosition(listOfCompetedTasks, elementPosition)
    }

    fun actionPressBack() {
        clickBack()
    }

    fun actionDeleteTheTaskAtPosition(elementPosition: Int) {
        actionClickOnDeleteButtonAtPosition(listOfCompetedTasks, elementPosition)
    }

    fun actionEditTheTaskAtPosition(elementPosition: Int) {
        actionClickOnTheTaskAtPosition(listOfCompetedTasks, elementPosition)
    }

    fun assertTheStatusOfTaskIsCheckedAtPosition(elementPosition: Int) {
        assertTheStatusIsCheckedAtPosition(listOfCompetedTasks, elementPosition)
    }

    fun assertDisplayedTaskTitleAtPosition(elementPosition: Int, textTitle: String) {
        assertDisplayedTitleAtPosition(listOfCompetedTasks, elementPosition, textTitle)
    }

    fun assertDisplayedTaskDescriptionAtPosition(elementPosition: Int, textDescription: String) {
        assertDisplayedDescriptionAtPosition(listOfCompetedTasks, elementPosition, textDescription)
    }

    fun assertDisplayedTaskDateAtPosition(elementPosition: Int, textDate: String) {
        assertDisplayedDateAtPosition(listOfCompetedTasks, elementPosition, textDate)
    }

    fun assertTasksHistoryIsEmpty() {
        assertListItemCount(listOfCompetedTasks, 0)
    }

    fun assertTaskIsNotFoundInTheList(title: String) {
        //assertTaskIsNotInTheList(listOfCompetedTasks, title)
    }
}