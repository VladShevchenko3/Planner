package com.android.dayplanner.app.screens

import android.view.View
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.android.dayplanner.app.R
import org.hamcrest.Matcher

object HistoryScreen : ListOfTasksBasic {

    private val listOfCompetedTasks: Matcher<View> = withId(R.id.recyclerView)

    fun actionUncheckTheTaskStatus(textTitle: String) {
        actionClickOnCheckBox(listOfCompetedTasks, textTitle)
    }

    fun actionPressBack() {
        pressBack()
    }

    fun actionDeleteTheTask(textTitle: String) {
        actionClickONDeleteButton(listOfCompetedTasks, textTitle)
    }

    fun actionEditTheTask(textTitle: String) {
        actionClickOnTheTask(listOfCompetedTasks, textTitle)
    }

    fun assertTheStatusOfTaskIsChecked(textTitle: String) {
        assertTheStatusIsChecked(listOfCompetedTasks, textTitle)
    }

    fun assertTaskAddedInTheList(textTitle: String, textDescription: String) {
        assertTheTaskIsInTheList(listOfCompetedTasks, textTitle, textDescription)
    }

    fun assertTasksHistoryIsEmpty() {
        assertTheListSize(listOfCompetedTasks, 0)
    }

    fun assertTaskIsNotFoundInTheList(title: String) {
        assertTaskIsNotInTheList(listOfCompetedTasks, title)
    }
}