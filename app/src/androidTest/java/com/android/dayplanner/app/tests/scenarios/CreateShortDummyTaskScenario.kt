package com.android.dayplanner.app.tests.scenarios

import com.android.dayplanner.app.screens.CreateTaskScreen
import com.android.dayplanner.app.screens.HomeScreen
import com.kaspersky.kaspresso.testcases.api.scenario.BaseScenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class CreateShortDummyTaskScenario<T>(
    private val title: String,
    private val description: String,
    private val date: String
) : BaseScenario<T>() {

    override val steps: TestContext<T>.() -> Unit
        get() = {
            step("Create task with title: <$title>, description: <$description>, date: <$date>") {
                HomeScreen {
                    actionClickOnFabTaskButton()
                }
                CreateTaskScreen {
                    actionClickOnCreateShortTempTaskButton()
                    actionEditTextTitle(title)
                    actionEditTextDescription(description)
                    actionEditTextData(date)
                    actionClickOnSaveButton()
                }
            }
        }
}