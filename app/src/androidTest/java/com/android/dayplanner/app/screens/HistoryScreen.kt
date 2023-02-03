package com.android.dayplanner.app.screens

import com.android.dayplanner.app.R
import com.android.dayplanner.app.screens.ListOfTasksBasic.TaskItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen

class HistoryScreen : Screen<HistoryScreen>(), ListOfTasksBasic {

    private val listOfCompetedTasks = KRecyclerView({
        withId(R.id.recyclerView)
    }, itemTypeBuilder = {
        itemType(::TaskItem)
    })

    fun actionUncheckTheTaskStatus(textTitle: String) {
        actionClickOnCheckBox(listOfCompetedTasks, textTitle)
    }

    fun actionPressBack() {
        pressBack()
    }

    fun actionDeleteTheTask(textTitle: String) {
        actionClickOnDeleteButton(listOfCompetedTasks, textTitle)
    }

    fun actionEditTheTask(textTitle: String) {
        actionClickOnTheTask(listOfCompetedTasks, textTitle)
    }

    fun assertTheStatusOfTaskIsChecked(textTitle: String) {
        assertTheStatusIsChecked(listOfCompetedTasks, textTitle)
    }

    fun assertTaskAddedInTheTaskHistory(textTitle: String, textDescription: String, date: String) {
        assertTheTaskIsInTheList(listOfCompetedTasks, textTitle, textDescription, date)
    }

    fun assertTasksHistoryIsEmpty() {
        assertTheListIsEmpty(listOfCompetedTasks)
    }

    fun assertTaskIsNotFoundInTheList(title: String) {
        assertTaskIsNotInList(listOfCompetedTasks, title)
    }
}