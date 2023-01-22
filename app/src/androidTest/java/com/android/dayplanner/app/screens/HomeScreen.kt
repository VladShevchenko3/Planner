package com.android.dayplanner.app.screens//package com.android.dayplanner.app.screens

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.android.dayplanner.app.R
import org.hamcrest.Matcher

object HomeScreen: ListOfTasksBasic {

    private val fabTaskButton: Matcher<View> = withId(R.id.floating_action_button)
    private val showHistoryView: Matcher<View> = withText(R.string.label_history)
    private val deleteAllTaskView: Matcher<View> = withText(R.string.label_delete_all)
    private val yesView: Matcher<View> = withText(R.string.yes)
    private val listOfTasksView: Matcher<View> = withId(R.id.recyclerView)

    fun actionClickOnFabTaskButton() {
        onView(fabTaskButton).perform(click())
    }

    fun actionDeleteTheTask(textTitle: String) {
        actionClickONDeleteButton(listOfTasksView, textTitle)
    }

    fun actionEditTheTask(textTitle: String) {
        actionClickOnTheTask(listOfTasksView, textTitle)
    }

    fun actionClickOnCompleteTheTask(textTitle: String) {
        actionClickOnCheckBox(listOfTasksView, textTitle)
    }

    fun actionOpensTheOverflowMenu() {
        openContextualActionModeOverflowMenu()
    }

    fun actionClickOnTheDeleteAllTasks() {
        onView(deleteAllTaskView).perform(click())
    }

    fun actionClickOnYesButton() {
        onView(yesView).perform(click())
    }

    fun actionClickOnTheTasksHistory() {
        onView(showHistoryView).perform(click())
    }

    fun assertTaskIsNotPresentOnScreen(title: String) {
        assertTaskIsNotInTheList(listOfTasksView, title)
    }

    fun assertTasksListIsEmpty() {
        assertTheListSize(listOfTasksView, 0)
    }

    fun assertTaskAddedInTheList(textTitle: String, textDescription: String) {
        assertTheTaskIsInTheList(listOfTasksView, textTitle, textDescription)
    }

    fun assertTheStatusOfTaskIsNotChecked(textTitle: String) {
        assertTheStatusIsNotChecked(listOfTasksView, textTitle)
    }
}