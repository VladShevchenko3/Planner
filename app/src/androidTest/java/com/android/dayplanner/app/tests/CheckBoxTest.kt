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

class CheckBoxTest : BaseTest() {

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Add the task 2 with title, description and date
    Step 3. Add the task 3 with title, description and date
    Step 4. Complete status of the task 1, task 2, task 3 on the Home screen
    Step 5. Check status of tasks is complete on the History screen
    Step 6. Uncheck status of tasks on the History screen
    Step 7. Check status of tasks is not complete on the Home screen
     * */
    @Test
    fun checkCheckBoxStatus() {
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
            assertTheStatusOfTaskIsChecked(TASK_TITLE1)
            assertTheStatusOfTaskIsChecked(TASK_TITLE2)
            assertTheStatusOfTaskIsChecked(TASK_TITLE3)
            actionUncheckTheTaskStatus(TASK_TITLE1)
            actionUncheckTheTaskStatus(TASK_TITLE2)
            actionUncheckTheTaskStatus(TASK_TITLE3)
            actionPressBack()
        }
        with(HomeScreen) {
            assertTheStatusOfTaskIsNotChecked(TASK_TITLE1)
            assertTheStatusOfTaskIsNotChecked(TASK_TITLE2)
            assertTheStatusOfTaskIsNotChecked(TASK_TITLE3)
        }
    }
}