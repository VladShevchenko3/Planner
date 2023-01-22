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
import org.junit.Test

class CreatingTasksTests : BaseTest() {

    @Test
    fun createTasks() = run {
        scenario(
            CreateCustomTaskScenario(
                TASK_TITLE1,
                TASK_DESCRIPTION1,
                TASK_DATE1
            )
        )
        step("Check the addition of task 1 on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(
                    TASK_TITLE1,
                    TASK_DESCRIPTION1,
                    TASK_DATE1
                )
            }
        }
        scenario(
            CreateLongDummyTaskScenario(
                TASK_TITLE2,
                TASK_DESCRIPTION2,
                TASK_DATE2
            )
        )
        step("Check the addition of task 2 on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(
                    TASK_TITLE2,
                    TASK_DESCRIPTION2,
                    TASK_DATE2
                )
            }
        }
        scenario(
            CreateShortDummyTaskScenario(
                TASK_TITLE3,
                TASK_DESCRIPTION3,
                TASK_DATE3
            )
        )
        step("Check the addition of task 3 on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(
                    TASK_TITLE3,
                    TASK_DESCRIPTION3,
                    TASK_DATE3
                )
            }
        }
    }

    @Test
    fun createTasksAndCompleteThem() = run {
        scenario(
            CreateCustomTaskScenario(
                TASK_TITLE1,
                TASK_DESCRIPTION1,
                TASK_DATE1
            )
        )
        scenario(
            CreateCustomTaskScenario(
                TASK_TITLE2,
                TASK_DESCRIPTION2,
                TASK_DATE2
            )
        )
        scenario(
            CreateCustomTaskScenario(
                TASK_TITLE3,
                TASK_DESCRIPTION3,
                TASK_DATE3
            )
        )
        step("Complete status of the task 1 on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(TASK_TITLE1)
            }
        }
        step("Complete status of the task 2 on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(TASK_TITLE2)
            }
        }
        step("Complete status of the task 3 on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(TASK_TITLE3)
            }
        }
        step("Open the \"TaskHistory\" screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheTasksHistory()
            }
        }
        step("Check the added task 1 on the \"History\" screen") {
            HistoryScreen {
                assertTaskAddedInTheTaskHistory(
                    TASK_TITLE1,
                    TASK_DESCRIPTION1,
                    TASK_DATE1
                )
            }
        }
        step("Check the added task 2 on the \"History\" screen") {
            HistoryScreen {
                assertTaskAddedInTheTaskHistory(
                    TASK_TITLE2,
                    TASK_DESCRIPTION2,
                    TASK_DATE2
                )
            }
        }
        step("Check the added task 3 on the \"History\" screen") {
            HistoryScreen {
                assertTaskAddedInTheTaskHistory(
                    TASK_TITLE3,
                    TASK_DESCRIPTION3,
                    TASK_DATE3
                )
            }
        }
    }
}