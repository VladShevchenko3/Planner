package com.android.dayplanner.app.screens

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.matcher.ViewMatchers.*
import com.android.dayplanner.app.R
import com.android.dayplanner.app.matches.RecycleViewActionsAndAsserts
import org.hamcrest.Matcher

interface ListOfTasksBasic : RecycleViewActionsAndAsserts {

    private val titleTextField: Int
        get() = R.id.textView_title
    private val descriptionTextField: Int
        get() = R.id.textView_description
    private val dateTextField: Int
        get() = R.id.textView_date
    private val deleteTaskButton: Int
        get() = R.id.imageView_delete
    private val completeTaskCheckBox: Int
        get() = R.id.checkBox

    fun actionClickOnCheckBox(recyclerView: Matcher<View>, textTitle: String) {
        onView(recyclerView).perform(
            actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(withText(textTitle)),
                actionOnChildView(completeTaskCheckBox, click())
            )
        )
    }

    fun actionClickONDeleteButton(recyclerView: Matcher<View>, textTitle: String) {
        onView(recyclerView).perform(
            actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(withText(textTitle)),
                actionOnChildView(deleteTaskButton, click())
            )
        )
    }

    fun actionClickOnTheTask(recyclerView: Matcher<View>, textTitle: String) {
        onView(recyclerView).perform(
            actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(withText(textTitle)), click()
            )
        )
    }

    fun assertTheTaskIsInTheList(
        recyclerView: Matcher<View>,
        textTitle: String,
        textDescription: String
    ) {
        onView(recyclerView)
            .check(
                matches(
                    assertOnChildView(
                        withText(textTitle),
                        withText(textDescription),
                        descriptionTextField
                    )
                )
            )
    }

    fun assertTheStatusIsChecked(recyclerView: Matcher<View>, textTitle: String) {
        onView(recyclerView)
            .check(
                matches(
                    assertOnChildView(withText(textTitle), isChecked(), completeTaskCheckBox)
                )
            )
    }

    fun assertTheStatusIsNotChecked(recyclerView: Matcher<View>, textTitle: String) {
        onView(recyclerView)
            .check(
                matches(
                    assertOnChildView(withText(textTitle), isNotChecked(), completeTaskCheckBox)
                )
            )
    }

    fun assertTheListSize(recyclerView: Matcher<View>, matcherSize: Int) {
        onView(recyclerView).check(matches(recyclerViewSizeMatcher(0)))
    }

    fun assertTaskIsNotInTheList(recyclerView: Matcher<View>, textTitle: String) {
        onView(recyclerView)
            .check(matches(assertItemDoesNotExist(withText(textTitle))))
    }
}