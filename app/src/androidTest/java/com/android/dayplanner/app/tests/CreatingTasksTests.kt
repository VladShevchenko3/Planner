package com.android.dayplanner.app.tests

import com.android.dayplanner.app.screens.CreateTaskScreen
import com.android.dayplanner.app.screens.HistoryScreen
import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.tests.DataForTests.getTaskData
import io.github.kakaocup.kakao.screen.Screen.Companion.onScreen
import org.junit.Test

class CreatingTasksTests : BaseTest() {

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
            assertTaskAddedInTheList(task1.title, task1.description, task1.date)
            actionClickOnFabTaskButton()
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(task2.title)
            actionEditTextDescription(task2.description)
            actionEditTextDate(task2.date)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            assertTaskAddedInTheList(task2.title, task2.description, task2.date)
            actionClickOnFabTaskButton()
        }
        onScreen<CreateTaskScreen> {
            actionEditTextTitle(task3.title)
            actionEditTextDescription(task3.description)
            actionEditTextDate(task3.date)
            actionClickOnSaveButton()
        }
        onScreen<HomeScreen> {
            assertTaskAddedInTheList(task3.title, task3.description, task3.date)
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
            assertTaskAddedInTheTaskHistory(
                task1.title,
                task1.description,
                task1.date
            )
            assertTaskAddedInTheTaskHistory(
                task2.title,
                task2.description,
                task2.date
            )
            assertTaskAddedInTheTaskHistory(
                task3.title,
                task3.description,
                task3.date
            )
        }
    }
}