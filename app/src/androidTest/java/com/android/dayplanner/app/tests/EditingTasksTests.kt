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
import io.github.kakaocup.kakao.screen.Screen.Companion.onScreen
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
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(TASK_TITLE1)
            actionEditTextDescription(TASK_DESCRIPTION1)
            actionEditTextDate(TASK_DATE1)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(TASK_TITLE2)
            actionEditTextDescription(TASK_DESCRIPTION2)
            actionEditTextDate(TASK_DATE2)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(TASK_TITLE3)
            actionEditTextDescription(TASK_DESCRIPTION3)
            actionEditTextDate(TASK_DATE3)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionEditTheTask(TASK_TITLE1)
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(EDIT_TASK_TITLE1)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION1)
            actionEditTextDate(EDIT_TASK_DATE1)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionEditTheTask(TASK_TITLE2)
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(EDIT_TASK_TITLE2)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION2)
            actionEditTextDate(EDIT_TASK_DATE2)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionEditTheTask(TASK_TITLE3)
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(EDIT_TASK_TITLE3)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION3)
            actionEditTextDate(EDIT_TASK_DATE3)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            assertTaskAddedInTheList(EDIT_TASK_TITLE1, EDIT_TASK_DESCRIPTION1, EDIT_TASK_DATE1)
            assertTaskAddedInTheList(EDIT_TASK_TITLE2, EDIT_TASK_DESCRIPTION2, EDIT_TASK_DATE2)
            assertTaskAddedInTheList(EDIT_TASK_TITLE3, EDIT_TASK_DESCRIPTION3, EDIT_TASK_DATE3)
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
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(TASK_TITLE1)
            actionEditTextDescription(TASK_DESCRIPTION1)
            actionEditTextDate(TASK_DATE1)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(TASK_TITLE2)
            actionEditTextDescription(TASK_DESCRIPTION2)
            actionEditTextDate(TASK_DATE2)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(TASK_TITLE3)
            actionEditTextDescription(TASK_DESCRIPTION3)
            actionEditTextDate(TASK_DATE3)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnCompleteTheTask(TASK_TITLE1)
            actionClickOnCompleteTheTask(TASK_TITLE2)
            actionClickOnCompleteTheTask(TASK_TITLE3)
            actionOpensTheOverflowMenu()
            actionClickOnTheTasksHistory()
        }
        onScreen<HistoryScreen> {
            actionEditTheTask(TASK_TITLE1)
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(EDIT_TASK_TITLE1)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION1)
            actionEditTextDate(EDIT_TASK_DATE1)
            actionClickOnSaveButton()
        }
        onScreen<HistoryScreen> {
            actionEditTheTask(TASK_TITLE2)
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(EDIT_TASK_TITLE2)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION2)
            actionEditTextDate(EDIT_TASK_DATE2)
            actionClickOnSaveButton()
        }
        onScreen<HistoryScreen> {
            actionEditTheTask(TASK_TITLE3)
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(EDIT_TASK_TITLE3)
            actionEditTextDescription(EDIT_TASK_DESCRIPTION3)
            actionEditTextDate(EDIT_TASK_DATE3)
            actionClickOnSaveButton()
        }
        onScreen<HistoryScreen> {
            assertTaskAddedInTheTaskHistory(
                EDIT_TASK_TITLE1,
                EDIT_TASK_DESCRIPTION1,
                EDIT_TASK_DATE1
            )
            assertTaskAddedInTheTaskHistory(
                EDIT_TASK_TITLE2,
                EDIT_TASK_DESCRIPTION2,
                EDIT_TASK_DATE2
            )
            assertTaskAddedInTheTaskHistory(
                EDIT_TASK_TITLE3,
                EDIT_TASK_DESCRIPTION3,
                EDIT_TASK_DATE3
            )
        }
    }
}