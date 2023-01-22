package com.android.dayplanner.app.screens

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.TypeTextAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.android.dayplanner.app.R
import org.hamcrest.Matcher

object CreateTaskScreen {

    private val buttonSaveTask: Matcher<View> = withId(R.id.button_saveTask)
    private val editTextTitle: Matcher<View> = withId(R.id.editText_title)
    private val editTextDescription: Matcher<View> = withId(R.id.editText_description)
    private val editTextDate: Matcher<View> = withId(R.id.editText_taskDate)
    private val buttonCreateLongTempTask: Matcher<View> = withId(R.id.button_createLongTempTask)
    private val buttonCreateShortTempTask: Matcher<View> = withId(R.id.button_createShortTempTask)

    fun actionEditTextTitle(textTitle: String) {
        onView(editTextTitle).perform(
            clearText(),
            TypeTextAction(textTitle),
            closeSoftKeyboard()
        )
    }

    fun actionEditTextDescription(textDescription: String) {
        onView(editTextDescription).perform(
            clearText(),
            TypeTextAction(textDescription),
            closeSoftKeyboard()
        )
    }

    fun actionEditTextData(textData: String) {
        onView(editTextDate).perform(
            clearText(),
            TypeTextAction(textData),
            closeSoftKeyboard()
        )
    }

    fun actionClickOnSaveButton() {
        onView(buttonSaveTask).perform(click())
    }

    fun actionClickOnCreateLongTempTaskButton() {
        onView(buttonCreateLongTempTask).perform(click())
    }

    fun actionClickOnCreateShortTempTaskButton() {
        onView(buttonCreateShortTempTask).perform(click())
    }
}