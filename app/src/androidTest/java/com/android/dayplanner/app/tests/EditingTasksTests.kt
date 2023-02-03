package com.android.dayplanner.app.tests

import com.android.dayplanner.app.screens.CreateTaskScreen
import com.android.dayplanner.app.screens.HistoryScreen
import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.tests.DataForTests.getTaskData
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
        val task1 = getTaskData(1)
        val task2 = getTaskData(2)
        val task3 = getTaskData(3)
        val task4 = getTaskData(4)
        val task5 = getTaskData(5)
        val task6 = getTaskData(6)
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
            actionEditTheTask(task1.title)
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(task4.title)
            actionEditTextDescription(task4.description)
            actionEditTextDate(task4.date)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionEditTheTask(task2.title)
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(task5.title)
            actionEditTextDescription(task5.description)
            actionEditTextDate(task5.date)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            actionEditTheTask(task3.title)
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(task6.title)
            actionEditTextDescription(task6.description)
            actionEditTextDate(task6.date)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            assertTaskAddedInTheList(task4.title, task4.description, task4.date)
            assertTaskAddedInTheList(task5.title, task5.description, task5.date)
            assertTaskAddedInTheList(task6.title, task6.description, task6.date)
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
        val task1 = getTaskData(1)
        val task2 = getTaskData(2)
        val task3 = getTaskData(3)
        val task4 = getTaskData(4)
        val task5 = getTaskData(5)
        val task6 = getTaskData(6)
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
            actionEditTheTask(task1.title)
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(task4.title)
            actionEditTextDescription(task4.description)
            actionEditTextDate(task4.date)
            actionClickOnSaveButton()
        }
        onScreen<HistoryScreen> {
            actionEditTheTask(task2.title)
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(task5.title)
            actionEditTextDescription(task5.description)
            actionEditTextDate(task5.date)
            actionClickOnSaveButton()
        }
        onScreen<HistoryScreen> {
            actionEditTheTask(task3.title)
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(task6.title)
            actionEditTextDescription(task6.description)
            actionEditTextDate(task6.date)
            actionClickOnSaveButton()
        }
        onScreen<HistoryScreen> {
            assertTaskAddedInTheTaskHistory(
                task4.title,
                task4.description,
                task4.date
            )
            assertTaskAddedInTheTaskHistory(
                task5.title,
                task5.description,
                task5.date
            )
            assertTaskAddedInTheTaskHistory(
                task6.title,
                task6.description,
                task6.date
            )
        }
    }
}