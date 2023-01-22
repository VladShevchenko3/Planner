package com.android.dayplanner.app.tests

import com.android.dayplanner.app.screens.CreateTaskScreen
import com.android.dayplanner.app.screens.HistoryScreen
import com.android.dayplanner.app.screens.HomeScreen
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

class DeleteTasksTest : BaseTest() {

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Add the task 2 with title, description and date
    Step 3. Add the task 3 with title, description and date
    Step 4. Delete all tasks wih toolBar on the Home screen
    Step 5. Check that the tasks list is empty on the Home screen
     * */
    @Test
    fun deleteAllTasksByToolbarOnHomeScreen() {
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
            actionOpensTheOverflowMenu()
            actionClickOnTheDeleteAllTasks()
            actionClickOnYesButton()
            assertTasksListIsEmpty()
        }
    }

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Add the task 2 with title, description and date
    Step 3. Add the task 3 with title, description and date
    Step 4. Delete task 1, task 2, task 3 on the Home screen
    Step 5. Check that the tasks list is empty on the Home screen
     * */
    @Test
    fun deleteAllTasksByButtonOnHomeScreen() {
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
            actionDeleteTheTask(TASK_TITLE1)
            actionDeleteTheTask(TASK_TITLE2)
            actionDeleteTheTask(TASK_TITLE3)
            assertTasksListIsEmpty()
        }
    }

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Delete task 1 on Home screen
    Step 3. Check that the task 1 is not present on the Home screen
     * */
    @Test
    fun deleteTheTaskByButtonOnHomeScreen() {
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
            actionDeleteTheTask(TASK_TITLE1)
            assertTaskIsNotPresentOnScreen(TASK_TITLE1)
        }
    }

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Complete status of the task 1 on the Home screen
    Step 2. Delete task 1 on History screen
    Step 3. Check that the task 1 is not present on the History screen
     * */
    @Test
    fun deleteTheTaskByButtonOnHistoryScreen() {
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
            actionClickOnCompleteTheTask(TASK_TITLE1)
            actionOpensTheOverflowMenu()
            actionClickOnTheTasksHistory()
        }
        with(HistoryScreen) {
            actionDeleteTheTask(TASK_TITLE1)
            assertTaskIsNotFoundInTheList(TASK_TITLE1)
        }
    }

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Add the task 2 with title, description and date
    Step 3. Add the task 3 with title, description and date
    Step 4. Complete status of the task 1, task 2, task 3 on the Home screen
    Step 5. Delete task 1, task 2, task 3 on the History screen
    Step 6. Check that the tasks list is empty on the History screen
     * */
    @Test
    fun deleteAllTaskOnHistoryScreen() {
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
            actionDeleteTheTask(TASK_TITLE1)
            actionDeleteTheTask(TASK_TITLE2)
            actionDeleteTheTask(TASK_TITLE3)
            assertTasksHistoryIsEmpty()
        }
    }
}