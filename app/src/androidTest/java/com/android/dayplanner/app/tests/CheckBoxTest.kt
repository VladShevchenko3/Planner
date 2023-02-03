package com.android.dayplanner.app.tests

import com.android.dayplanner.app.screens.CreateTaskScreen
import com.android.dayplanner.app.screens.HistoryScreen
import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.tests.DataForTests.getTaskData
import io.github.kakaocup.kakao.screen.Screen.Companion.onScreen
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
     **/
    @Test
    fun checkCheckBoxStatus() {
        val task1 = getTaskData(1)
        val task2 = getTaskData(2)
        val task3 = getTaskData(3)
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(task1.title)
            actionEditTextDescription(task1.description)
            actionEditTextDate(task1.date)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(task2.title)
            actionEditTextDescription(task2.description)
            actionEditTextDate(task2.date)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnFabTaskButton()
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(task3.title)
            actionEditTextDescription(task3.description)
            actionEditTextDate(task3.date)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionClickOnCompleteTheTask(task1.title)
            actionClickOnCompleteTheTask(task2.title)
            actionClickOnCompleteTheTask(task3.title)
            actionOpensTheOverflowMenu()
            actionClickOnTheTasksHistory()
        }
        onScreen<HistoryScreen> {
            assertTheStatusOfTaskIsChecked(task1.title)
            assertTheStatusOfTaskIsChecked(task2.title)
            assertTheStatusOfTaskIsChecked(task3.title)
            actionUncheckTheTaskStatus(task1.title)
            actionUncheckTheTaskStatus(task2.title)
            actionUncheckTheTaskStatus(task3.title)
            actionPressBack()
        }
        onScreen<HomeScreen> {
            assertTheStatusOfTaskIsNotChecked(task1.title)
            assertTheStatusOfTaskIsNotChecked(task2.title)
            assertTheStatusOfTaskIsNotChecked(task3.title)
        }
    }
}