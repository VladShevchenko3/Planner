package com.android.dayplanner.app.tests.smoketests

import com.android.dayplanner.app.screens.HistoryScreen
import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.tests.BaseTest
import com.android.dayplanner.app.tests.DataForTests.TASK_DATE1
import com.android.dayplanner.app.tests.DataForTests.TASK_DATE2
import com.android.dayplanner.app.tests.DataForTests.TASK_DATE3
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION1
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION2
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION3
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE1
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE2
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE3
import com.android.dayplanner.app.tests.scenarios.CreateCustomTaskScenario
import com.android.dayplanner.app.tests.scenarios.CreateLongDummyTaskScenario
import com.android.dayplanner.app.tests.scenarios.CreateShortDummyTaskScenario
import com.android.dayplanner.app.tests.scenarios.DeleteTaskByTitle
import org.junit.Test

class DeleteTasksTests : BaseTest() {
    @Test
    fun deleteAllTasksByToolbarOnHomeScreen() = run {
        scenario(
            CreateCustomTaskScenario(
                TASK_TITLE1,
                TASK_DESCRIPTION1,
                TASK_DATE1
            )
        )
        scenario(
            CreateLongDummyTaskScenario(
                TASK_TITLE2,
                TASK_DESCRIPTION2,
                TASK_DATE2
            )
        )
        scenario(
            CreateShortDummyTaskScenario(
                TASK_TITLE3,
                TASK_DESCRIPTION3,
                TASK_DATE3
            )
        )
        step("Delete all tasks wih toolBar on \"Home\" screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheDeleteAllTasks()
                actionClickOnYesButton()
            }
        }
        step("Check that the tasks list is empty on \"Home\" screen") {
            HomeScreen {
                assertTaskListIsEmpty()
            }
        }
    }

    @Test
    fun deleteAllTasksByButtonOnHomeScreen() = run {
        scenario(
            CreateCustomTaskScenario(
                TASK_TITLE1,
                TASK_DESCRIPTION1,
                TASK_DATE1
            )
        )
        scenario(
            CreateLongDummyTaskScenario(
                TASK_TITLE2,
                TASK_DESCRIPTION2,
                TASK_DATE2
            )
        )
        scenario(
            CreateShortDummyTaskScenario(
                TASK_TITLE3,
                TASK_DESCRIPTION3,
                TASK_DATE3
            )
        )
        scenario(DeleteTaskByTitle(TASK_TITLE1))
        scenario(DeleteTaskByTitle(TASK_TITLE2))
        scenario(DeleteTaskByTitle(TASK_TITLE3))
        step("Check that the tasks list is empty on \"Home\" screen") {
            HomeScreen {
                assertTaskListIsEmpty()
            }
        }
    }

    @Test
    fun deleteTheTaskByButtonOnHomeScreen() = run {
        scenario(
            CreateCustomTaskScenario(
                TASK_TITLE1,
                TASK_DESCRIPTION1,
                TASK_DATE1
            )
        )
        step("Complete status of the task 1 on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(TASK_TITLE1)
            }
        }
        step("Go to History Screen screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheTasksHistory()
            }
        }
        scenario(DeleteTaskByTitle(TASK_TITLE1))
        step("Check that the task 1 is not present on the History screen") {
            HistoryScreen {
                assertTaskIsNotFoundInTheList(TASK_TITLE1)
            }
        }
    }

    @Test
    fun deleteAllTaskOnHistoryScreen() = run {
        scenario(
            CreateCustomTaskScenario(
                TASK_TITLE1,
                TASK_DESCRIPTION1,
                TASK_DATE1
            )
        )
        scenario(
            CreateLongDummyTaskScenario(
                TASK_TITLE2,
                TASK_DESCRIPTION2,
                TASK_DATE2
            )
        )
        scenario(
            CreateShortDummyTaskScenario(
                TASK_TITLE3,
                TASK_DESCRIPTION3,
                TASK_DATE3
            )
        )
        step("Complete status of the task 1, task 2, task 3 on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(TASK_TITLE1)
                actionClickOnCompleteTheTask(TASK_TITLE2)
                actionClickOnCompleteTheTask(TASK_TITLE3)
            }
        }
        step("Go to History Screen screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheTasksHistory()
            }
        }
        scenario(DeleteTaskByTitle(TASK_TITLE1))
        scenario(DeleteTaskByTitle(TASK_TITLE2))
        scenario(DeleteTaskByTitle(TASK_TITLE3))
        step("Check that the tasks list is empty on the \"History\" screen") {
            HistoryScreen {
                assertTasksHistoryIsEmpty()
            }
        }
    }

    @Test
    fun deleteTheTaskByButtonOnHistoryScreen() = run {
        scenario(
            CreateCustomTaskScenario(
                TASK_TITLE1,
                TASK_DESCRIPTION1,
                TASK_DATE1
            )
        )
        step("Complete status of the task 1 on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(TASK_TITLE1)
            }
        }
        step("Go to History Screen screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheTasksHistory()
            }
        }
        scenario(DeleteTaskByTitle(TASK_TITLE1))
        step("Check that the task 1 is not present on the \"History\" screen") {
            HistoryScreen {
                assertTaskIsNotFoundInTheList(TASK_TITLE1)
            }
        }
    }
}