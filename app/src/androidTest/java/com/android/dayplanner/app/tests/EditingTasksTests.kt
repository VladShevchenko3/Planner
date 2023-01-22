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

class EditingTasksTests : BaseTest() {

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Add the task 2 with title, description and date
    Step 3. Add the task 3 with title, description and date
    Step 4. Edit task 1, task 2, task 3 on the Home screen
    Step 5. Check the modify task 1, task 2, task 3 is displayed on the Home screen
     * */
    @Test
    fun editTasksOnTheHomeScreen() {
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(TASK_TITLE1)
            actionEditTextDescription(TASK_DESCRIPTION1)
            actionEditTextData(TASK_DATE1)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionClickOnCreateLongTempTaskButton()
            actionEditTextTitle(TASK_TITLE2)
            actionEditTextDescription(TASK_DESCRIPTION2)
            actionEditTextData(TASK_DATE2)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionClickOnCreateShortTempTaskButton()
            actionEditTextTitle(TASK_TITLE3)
            actionEditTextDescription(TASK_DESCRIPTION3)
            actionEditTextData(TASK_DATE3)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionEditTheTask(TASK_TITLE1)
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(EDIT_TASK_TITLE1)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION1)
            actionEditTextData(EDIT_TASK_DATE1)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionEditTheTask(TASK_TITLE2)
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(EDIT_TASK_TITLE2)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION2)
            actionEditTextData(EDIT_TASK_DATE2)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionEditTheTask(TASK_TITLE3)
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(EDIT_TASK_TITLE3)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION3)
            actionEditTextData(EDIT_TASK_DATE3)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            assertTaskAddedInTheList(EDIT_TASK_TITLE1, EDIT_TASK_DESCRIPTION1)
            assertTaskAddedInTheList(EDIT_TASK_TITLE2, EDIT_TASK_DESCRIPTION2)
            assertTaskAddedInTheList(EDIT_TASK_TITLE3, EDIT_TASK_DESCRIPTION3)

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
            actionEditTextData(TASK_DATE1)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionClickOnCreateLongTempTaskButton()
            actionEditTextTitle(TASK_TITLE2)
            actionEditTextDescription(TASK_DESCRIPTION2)
            actionEditTextData(TASK_DATE2)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionClickOnCreateShortTempTaskButton()
            actionEditTextTitle(TASK_TITLE3)
            actionEditTextDescription(TASK_DESCRIPTION3)
            actionEditTextData(TASK_DATE3)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnCompleteTheTask(TASK_TITLE1)
            actionClickOnCompleteTheTask(TASK_TITLE2)
            actionClickOnCompleteTheTask(TASK_TITLE3)
            actionOpensTheOverflowMenu()
            actionClickOnTheTasksHistory()
        }
        with(HistoryScreen) {
            actionEditTheTask(TASK_TITLE1)
        }
        with(CreateTaskScreen) {

            actionEditTextTitle(EDIT_TASK_TITLE1)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION1)
            actionEditTextData(EDIT_TASK_DATE1)
            actionClickOnSaveButton()
        }
        with(HistoryScreen) {
            actionEditTheTask(TASK_TITLE2)
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(EDIT_TASK_TITLE2)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION2)
            actionEditTextData(EDIT_TASK_DATE2)
            actionClickOnSaveButton()
        }
        with(HistoryScreen) {
            actionEditTheTask(TASK_TITLE3)
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(EDIT_TASK_TITLE3)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION3)
            actionEditTextData(EDIT_TASK_DATE3)
            actionClickOnSaveButton()
        }
        with(HistoryScreen) {
            assertTaskAddedInTheList(
                EDIT_TASK_TITLE1,
                EDIT_TASK_DESCRIPTION1
            )
            assertTaskAddedInTheList(
                EDIT_TASK_TITLE2,
                EDIT_TASK_DESCRIPTION2
            )
            assertTaskAddedInTheList(
                EDIT_TASK_TITLE3,
                EDIT_TASK_DESCRIPTION3
            )
        }
    }
}