package com.android.dayplanner.app.tests.smoketests

import com.android.dayplanner.app.screens.HistoryScreen
import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.tests.BaseTest
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
import com.android.dayplanner.app.tests.scenarios.CreateCustomTaskScenario
import com.android.dayplanner.app.tests.scenarios.CreateLongDummyTaskScenario
import com.android.dayplanner.app.tests.scenarios.CreateShortDummyTaskScenario
import com.android.dayplanner.app.tests.scenarios.EditTaskScenario
import org.junit.Test

class EditingTasksTests : BaseTest() {

    @Test
    fun editTasksOnTheHomeScreen() = run {
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
        step("Edit the task 1 on the \"Home\" screen") {
            HomeScreen {
                actionEditTheTask(TASK_TITLE1)
            }
        }
        scenario(
            EditTaskScenario(
                EDIT_TASK_TITLE1,
                EDIT_TASK_DESCRIPTION1,
                EDIT_TASK_DATE1
            )
        )
        step("Check the modify task 1 is displayed on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(
                    EDIT_TASK_TITLE1,
                    EDIT_TASK_DESCRIPTION1,
                    EDIT_TASK_DATE1
                )
            }
        }
        step("Edit the task2 on the \"Home\" screen") {
            HomeScreen {
                actionEditTheTask(TASK_TITLE2)
            }
        }
        scenario(
            EditTaskScenario(
                EDIT_TASK_TITLE2,
                EDIT_TASK_DESCRIPTION2,
                EDIT_TASK_DATE2
            )
        )
        step("Check the modify task 2 is displayed on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(
                    EDIT_TASK_TITLE2,
                    EDIT_TASK_DESCRIPTION2,
                    EDIT_TASK_DATE2
                )
            }
        }
        step("Edit the task 3 on the \"Home\" screen") {
            HomeScreen {
                actionEditTheTask(TASK_TITLE3)
            }
        }
        scenario(
            EditTaskScenario(
                EDIT_TASK_TITLE3,
                EDIT_TASK_DESCRIPTION3,
                EDIT_TASK_DATE3
            )
        )
        step("Check the modify task 3 is displayed on the \"Home\" screen") {
            HomeScreen {
                assertTaskAddedInTheList(
                    EDIT_TASK_TITLE3,
                    EDIT_TASK_DESCRIPTION3,
                    EDIT_TASK_DATE3
                )
            }
        }
    }

    @Test
    fun editTasksOnTheHistoryScreen() = run {
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
        step("Check complete status of the task 1 on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(TASK_TITLE1)
            }
        }
        step("Check complete status of the task 2 on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(TASK_TITLE2)
            }
        }
        step("Check complete status of the task 3 on the \"Home\" screen") {
            HomeScreen {
                actionClickOnCompleteTheTask(TASK_TITLE3)
            }
        }
        step("Open the \"History\" screen") {
            HomeScreen {
                actionOpensTheOverflowMenu()
                actionClickOnTheTasksHistory()
            }
        }
        step("Edit the task 1 on the \"History\" screen") {
            HistoryScreen {
                actionEditTheTask(TASK_TITLE1)
            }
        }
        scenario(
            EditTaskScenario(
                EDIT_TASK_TITLE1,
                EDIT_TASK_DESCRIPTION1,
                EDIT_TASK_DATE1
            )
        )
        step("Check the modify task 1 is displayed on the \"History\" screen") {
            HistoryScreen {
                assertTaskAddedInTheTaskHistory(
                    EDIT_TASK_TITLE1,
                    EDIT_TASK_DESCRIPTION1,
                    EDIT_TASK_DATE1
                )
            }
        }
        step("Edit the task 2 on the \"History\" screen") {
            HistoryScreen {
                actionEditTheTask(TASK_TITLE2)
            }
        }
        scenario(
            EditTaskScenario(
                EDIT_TASK_TITLE2,
                EDIT_TASK_DESCRIPTION2,
                EDIT_TASK_DATE2
            )
        )
        step("Check the modify task 2 is displayed on the \"History\" screen") {
            HistoryScreen {
                assertTaskAddedInTheTaskHistory(
                    EDIT_TASK_TITLE2,
                    EDIT_TASK_DESCRIPTION2,
                    EDIT_TASK_DATE2
                )
            }
        }
        step("Edit the task 3 on the \"History\" screen") {
            HistoryScreen {
                actionEditTheTask(TASK_TITLE3)
            }
        }
        scenario(
            EditTaskScenario(
                EDIT_TASK_TITLE3,
                EDIT_TASK_DESCRIPTION3,
                EDIT_TASK_DATE3
            )
        )
        step("Check the modify task 3 is displayed on the \"History\" screen") {
            HistoryScreen {
                assertTaskAddedInTheTaskHistory(
                    EDIT_TASK_TITLE3,
                    EDIT_TASK_DESCRIPTION3,
                    EDIT_TASK_DATE3
                )
            }
        }
    }
}