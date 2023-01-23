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

class CreatingTasksTests : BaseTest() {

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Add the task 2 with title, description and date
    Step 3. Add the task 3 with title, description and date
    Step 4. Check the addition of task 1 with all data at position 2 on the Home screen
    Step 5. Check the addition of task 2 with all data at position 1 on the Home screen
    Step 6. Check the addition of task 3 with all data at position 0 on the Home screen
     * */
    @Test
    fun createTasks() {
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
            actionEditTextTitle(TASK_TITLE2)
            actionEditTextDescription(TASK_DESCRIPTION2)
            actionEditTextDate(TASK_DATE2)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(TASK_TITLE3)
            actionEditTextDescription(TASK_DESCRIPTION3)
            actionEditTextDate(TASK_DATE3)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            assertDisplayedTaskTitleAtPosition(2, TASK_TITLE1)
            assertDisplayedTaskDescriptionAtPosition(2, TASK_DESCRIPTION1)
            assertDisplayedTaskDateAtPosition(2, TASK_DATE1)
            assertDisplayedTaskTitleAtPosition(1, TASK_TITLE2)
            assertDisplayedTaskDescriptionAtPosition(1, TASK_DESCRIPTION2)
            assertDisplayedTaskDateAtPosition(1, TASK_DATE3)
            assertDisplayedTaskTitleAtPosition(0, TASK_TITLE3)
            assertDisplayedTaskDescriptionAtPosition(0, TASK_DESCRIPTION3)
            assertDisplayedTaskDateAtPosition(0, TASK_DATE3)
        }
    }

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Add the task 2 with title, description and date
    Step 3. Add the task 3 with title, description and date
    Step 4. Complete status of the task 1(position 2), task 2(position 1), task 3(position 0) on the Home screen
    Step 5. Check the addition of task 1 with all data at position 2 on the History screen
    Step 6. Check the addition of task 2 with all data at position 1 on the History screen
    Step 7. Check the addition of task 3 with all data at position 0 on the History screen
     * */
    @Test
    fun createTasksAndCompleteThem() {
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
            actionEditTextTitle(TASK_TITLE2)
            actionEditTextDescription(TASK_DESCRIPTION2)
            actionEditTextDate(TASK_DATE2)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnFabTaskButton()
        }
        with(CreateTaskScreen) {
            actionEditTextTitle(TASK_TITLE3)
            actionEditTextDescription(TASK_DESCRIPTION3)
            actionEditTextDate(TASK_DATE3)
            actionClickOnSaveButton()
        }
        with(HomeScreen) {
            actionClickOnCompleteTheTaskAtPosition(2)
            Thread.sleep(5000)
            actionClickOnCompleteTheTaskAtPosition(1)
            actionClickOnCompleteTheTaskAtPosition(0)

            actionOpenMenu()
            actionClickOnTheTasksHistory()
        }
        with(HistoryScreen) {
            assertDisplayedTaskTitleAtPosition(2, TASK_TITLE1)
            assertDisplayedTaskDescriptionAtPosition(2, TASK_DESCRIPTION1)
            assertDisplayedTaskDateAtPosition(2, TASK_DATE1)
            assertDisplayedTaskTitleAtPosition(1, TASK_TITLE2)
            assertDisplayedTaskDescriptionAtPosition(1, TASK_DESCRIPTION2)
            assertDisplayedTaskDateAtPosition(1, TASK_DATE2)
            assertDisplayedTaskTitleAtPosition(0, TASK_TITLE3)
            assertDisplayedTaskDescriptionAtPosition(0, TASK_DESCRIPTION3)
            assertDisplayedTaskDateAtPosition(0, TASK_DATE3)
        }
    }
}