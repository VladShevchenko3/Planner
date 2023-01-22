package com.android.dayplanner.app.tests.scenarios

import com.android.dayplanner.app.screens.CreateTaskScreen
import com.android.dayplanner.app.screens.HomeScreen.actionDeleteTheTask
import com.kaspersky.kaspresso.testcases.api.scenario.BaseScenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class DeleteTaskByTitle<T>(private val title: String) : BaseScenario<T>() {
    override val steps: TestContext<T>.() -> Unit
        get() = {
            step("Delete task with title: <$title>") {
                CreateTaskScreen {
                    actionDeleteTheTask(title)
                }
            }
        }
}