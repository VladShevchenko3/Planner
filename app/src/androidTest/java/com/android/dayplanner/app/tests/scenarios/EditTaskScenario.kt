package com.android.dayplanner.app.tests.scenarios

import com.android.dayplanner.app.screens.CreateTaskScreen
import com.kaspersky.kaspresso.testcases.api.scenario.BaseScenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class EditTaskScenario<T>(
    private val title: String,
    private val description: String,
    private val date: String
) : BaseScenario<T>() {

    override val steps: TestContext<T>.() -> Unit
        get() = {
            step("Edit task with title: <$title>, description: <$description>, date: <$date>") {
                CreateTaskScreen {
                    actionEditTextTitle(title)
                    actionEditTextDescription(description)
                    actionEditTextData(date)
                    actionClickOnSaveButton()
                }
            }
        }
}