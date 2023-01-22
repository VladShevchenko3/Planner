package com.android.dayplanner.app.tests

import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.screens.CreateTaskScreen
import com.android.dayplanner.app.screens.HistoryScreen
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

class CreatingTasksTest : BaseTest() {

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Check the addition of task 1 on the Home screen
    Step 3. Add the task 2 with title, description and date
    Step 4. Check the addition of task 2 on the Home screen
    Step 5. Add the task 3 with title, description and date
    Step 6. Check the addition of task 3 on the Home screen
     * */
    @Test
    fun createTasks() {
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
            assertTaskAddedInTheList(TASK_TITLE1, TASK_DESCRIPTION1)
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(TASK_TITLE2)
            actionEditTextDescription(TASK_DESCRIPTION2)
            actionEditTextData(TASK_DATE2)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            assertTaskAddedInTheList(TASK_TITLE2, TASK_DESCRIPTION2)
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionClickOnCreateLongTempTaskButton()
            actionEditTextTitle(TASK_TITLE3)
            actionEditTextDescription(TASK_DESCRIPTION3)
            actionEditTextData(TASK_DATE3)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            assertTaskAddedInTheList(TASK_TITLE3, TASK_DESCRIPTION3)
        }
    }

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Add the task 2 with title, description and date
    Step 3. Add the task 3 with title, description and date
    Step 4. Complete status of the task 1, task 2, task 3 on the Home screen
    Step 5. Check the addition of tasks on the History screen
     * */
    @Test
    fun createTasksAndCompleteThem() {
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
            actionEditTextTitle(TASK_TITLE2)
            actionEditTextDescription(TASK_DESCRIPTION2)
            actionEditTextData(TASK_DATE2)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionClickOnCreateLongTempTaskButton()
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
            assertTaskAddedInTheList(
                TASK_TITLE1,
                TASK_DESCRIPTION1
            )
        }
        with(HistoryScreen) {
            assertTaskAddedInTheList(
                TASK_TITLE2,
                TASK_DESCRIPTION2
            )
        }
        with(HistoryScreen) {
            assertTaskAddedInTheList(
                TASK_TITLE3,
                TASK_DESCRIPTION3
            )
        }
    }
}