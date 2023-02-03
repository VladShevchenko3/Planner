package com.android.dayplanner.app.tests

import com.android.dayplanner.app.screens.CreateTaskScreen
import com.android.dayplanner.app.screens.HistoryScreen
import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.tests.DataForTests.getTaskData
import io.github.kakaocup.kakao.screen.Screen.Companion.onScreen
import org.junit.Test

class DeleteTaskTests : BaseTest() {

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Add the task 2 with title, description and date
    Step 3. Add the task 3 with title, description and date
    Step 4. Delete all tasks wih toolBar on the Home screen
    Step 5. Check that the tasks list is empty on the Home screen
     * */
    @Test
    fun deleteAllTasksByToolbarOnHomeScreen() {
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
            actionOpensTheOverflowMenu()
            actionClickOnTheDeleteAllTasks()
            actionClickOnYesButton()
            assertTheTaskListIsEmpty()
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
            actionDeleteTheTask(task1.title)
            actionDeleteTheTask(task2.title)
            actionDeleteTheTask(task3.title)
            assertTheTaskListIsEmpty()
        }
    }

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Delete task 1 on Home screen
    Step 3. Check that the task 1 is not present on the Home screen
     * */
    @Test
    fun deleteTheTaskByButtonOnHomeScreen() {
        val task1 = getTaskData(1)
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
            actionDeleteTheTask(task1.title)
            assertTaskIsNotPresentInList(task1.title)
        }
    }

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Complete status of the task 1 on the Home screen
    Step 3. Delete task 1 on History screen
    Step 4. Check that the task 1 is not present on the History screen
     * */
    @Test
    fun deleteTheTaskByButtonOnHistoryScreen() {
        val task1 = getTaskData(1)
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
            actionClickOnCompleteTheTask(task1.title)
            actionOpensTheOverflowMenu()
            actionClickOnTheTasksHistory()
        }
        onScreen<HistoryScreen> {
            actionDeleteTheTask(task1.title)
            assertTaskIsNotFoundInTheList(task1.title)
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
            actionDeleteTheTask(task1.title)
            actionDeleteTheTask(task2.title)
            actionDeleteTheTask(task3.title)
            assertTasksHistoryIsEmpty()
        }
    }
}