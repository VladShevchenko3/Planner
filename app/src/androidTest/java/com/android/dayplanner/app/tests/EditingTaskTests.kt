package com.android.dayplanner.app.tests

import com.android.dayplanner.app.screens.CreateTaskScreen
import com.android.dayplanner.app.screens.HistoryScreen
import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.tests.DataForTests.EDIT_TASK_DATE1
import com.android.dayplanner.app.tests.DataForTests.EDIT_TASK_DATE2
import com.android.dayplanner.app.tests.DataForTests.EDIT_TASK_DATE3
import com.android.dayplanner.app.tests.DataForTests.EDIT_TASK_DESCRIPTION1
import com.android.dayplanner.app.tests.DataForTests.EDIT_TASK_DESCRIPTION2
import com.android.dayplanner.app.tests.DataForTests.EDIT_TASK_DESCRIPTION3
import com.android.dayplanner.app.tests.DataForTests.EDIT_TASK_TITLE1
import com.android.dayplanner.app.tests.DataForTests.EDIT_TASK_TITLE2
import com.android.dayplanner.app.tests.DataForTests.EDIT_TASK_TITLE3
import com.android.dayplanner.app.tests.DataForTests.TASK_DATE1
import com.android.dayplanner.app.tests.DataForTests.TASK_DATE2
import com.android.dayplanner.app.tests.DataForTests.TASK_DATE3
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION1
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION2
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION3
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE1
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE2
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE3
import org.junit.Test

class EditingTaskTests : BaseTest() {

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Add the task 2 with title, description and date
    Step 3. Add the task 3 with title, description and date
    Step 4. Edit task 1(position 2), task 2(position 1), task 3(position 0) on the Home screen
    Step 5. Check the modify task 1(position 2), task 2(position 1), task 3(position 0) is displayed on the Home screen
     * */
    @Test
    fun editTasksOnTheHomeScreen() {
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(TASK_TITLE1)
            actionEditTextDescription(TASK_DESCRIPTION1)
            actionEditTextDate(TASK_DATE1)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionClickOnCreateLongTempTaskButton()
            actionEditTextTitle(TASK_TITLE2)
            actionEditTextDescription(TASK_DESCRIPTION2)
            actionEditTextDate(TASK_DATE2)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionClickOnCreateShortTempTaskButton()
            actionEditTextTitle(TASK_TITLE3)
            actionEditTextDescription(TASK_DESCRIPTION3)
            actionEditTextDate(TASK_DATE3)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionEditTheTaskAtPosition(2)
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(EDIT_TASK_TITLE1)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION1)
            actionEditTextDate(EDIT_TASK_DATE1)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionEditTheTaskAtPosition(1)
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(EDIT_TASK_TITLE2)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION2)
            actionEditTextDate(EDIT_TASK_DATE2)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionEditTheTaskAtPosition(0)
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(EDIT_TASK_TITLE3)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION3)
            actionEditTextDate(EDIT_TASK_DATE3)
            actionClickOnSaveButton()
        }
        with(HistoryScreen) {
            assertDisplayedTaskTitleAtPosition(2, EDIT_TASK_TITLE1)
            assertDisplayedTaskDescriptionAtPosition(2, EDIT_TASK_DESCRIPTION1)
            assertDisplayedTaskDateAtPosition(2, EDIT_TASK_DATE1)
            assertDisplayedTaskTitleAtPosition(1, EDIT_TASK_TITLE2)
            assertDisplayedTaskDescriptionAtPosition(1, EDIT_TASK_DESCRIPTION2)
            assertDisplayedTaskDateAtPosition(1, EDIT_TASK_DATE2)
            assertDisplayedTaskTitleAtPosition(0, EDIT_TASK_TITLE3)
            assertDisplayedTaskDescriptionAtPosition(0, EDIT_TASK_DESCRIPTION3)
            assertDisplayedTaskDateAtPosition(0, EDIT_TASK_DATE3)
        }
    }

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Add the task 2 with title, description and date
    Step 3. Add the task 3 with title, description and date
    Step 4. Complete status of the task 1, task 2, task 3 on the Home screen
    Step 5. Edit task 1, task 2, task 3 on the History screen
    Step 6. Check the modify task 1, task 2, task 3 is displayed on the History screen
     * */
    @Test
    fun editTasksOnTheHistoryScreen() {
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(TASK_TITLE1)
            actionEditTextDescription(TASK_DESCRIPTION1)
            actionEditTextDate(TASK_DATE1)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionClickOnCreateLongTempTaskButton()
            actionEditTextTitle(TASK_TITLE2)
            actionEditTextDescription(TASK_DESCRIPTION2)
            actionEditTextDate(TASK_DATE2)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionClickOnCreateShortTempTaskButton()
            actionEditTextTitle(TASK_TITLE3)
            actionEditTextDescription(TASK_DESCRIPTION3)
            actionEditTextDate(TASK_DATE3)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnCompleteTheTaskAtPosition(0)
            actionClickOnCompleteTheTaskAtPosition(1)
            actionClickOnCompleteTheTaskAtPosition(2)
            actionOpenMenu()
            actionClickOnTheTasksHistory()
        }
        with(HistoryScreen) {
            actionEditTheTaskAtPosition(2)
        }
        with(CreateTaskScreen) {

            actionEditTextTitle(EDIT_TASK_TITLE1)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION1)
            actionEditTextDate(EDIT_TASK_DATE1)
            actionClickOnSaveButton()
        }
        with(HistoryScreen) {
            actionEditTheTaskAtPosition(1)
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(EDIT_TASK_TITLE2)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION2)
            actionEditTextDate(EDIT_TASK_DATE2)
            actionClickOnSaveButton()
        }
        with(HistoryScreen) {
            actionEditTheTaskAtPosition(0)
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(EDIT_TASK_TITLE3)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION3)
            actionEditTextDate(EDIT_TASK_DATE3)
            actionClickOnSaveButton()
        }
        with(HistoryScreen) {
            assertDisplayedTaskTitleAtPosition(2, EDIT_TASK_TITLE1)
            assertDisplayedTaskDescriptionAtPosition(2, EDIT_TASK_DESCRIPTION1)
            assertDisplayedTaskDateAtPosition(2, EDIT_TASK_DATE1)
            assertDisplayedTaskTitleAtPosition(1, EDIT_TASK_TITLE2)
            assertDisplayedTaskDescriptionAtPosition(1, EDIT_TASK_DESCRIPTION2)
            assertDisplayedTaskDateAtPosition(1, EDIT_TASK_DATE2)
            assertDisplayedTaskTitleAtPosition(0, EDIT_TASK_TITLE3)
            assertDisplayedTaskDescriptionAtPosition(0, EDIT_TASK_DESCRIPTION3)
            assertDisplayedTaskDateAtPosition(0, EDIT_TASK_DATE3)
        }
    }
}