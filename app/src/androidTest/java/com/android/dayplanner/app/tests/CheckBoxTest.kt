package com.android.dayplanner.app.tests

import com.android.dayplanner.app.screens.CreateTaskScreen
import com.android.dayplanner.app.screens.HomeScreen
import com.android.dayplanner.app.tests.DataForTests.TASK_DATE1
import com.android.dayplanner.app.tests.DataForTests.TASK_DESCRIPTION1
import com.android.dayplanner.app.tests.DataForTests.TASK_TITLE1
import org.junit.Test

class CheckBoxTest : BaseTest() {

    /** Scenario
    Step 1. Add the task 1 with title, description and date
    Step 2. Add the task 2 with title, description and date
    Step 3. Add the task 3 with title, description and date
    Step 4. Complete status of the task 1(position 2), task 2(position 1), task 3(position 0) on the Home screen
    Step 5. Check status of tasks at all positions is complete on the History screen
     * */
//    @Test
//    fun checkCheckBoxStatusOnHomeScreen() {
//        with(HomeScreen) {
//            actionClickOnFabTaskButton()
//        }
//        with(CreateTaskScreen) {
//            actionEditTextTitle(TASK_TITLE1)
//            actionEditTextDescription(TASK_DESCRIPTION1)
//            actionEditTextDate(TASK_DATE1)
//            actionClickOnSaveButton()
//        }
//        with(HomeScreen) {
//            assertTheStatusOfTaskIsNotCheckedAtPosition(0)
//            Thread.sleep(5000)
//        }
//    }
}