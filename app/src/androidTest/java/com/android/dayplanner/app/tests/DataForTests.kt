package com.android.dayplanner.app.tests

import androidx.test.platform.app.InstrumentationRegistry
import org.json.JSONObject

object DataForTests {

    private fun geJSONContent(path: String) =
        InstrumentationRegistry.getInstrumentation().context.assets
            .open("${path}.json").bufferedReader().readText()

    fun getTaskData(id: Int): TaskData {
        val fileName = "tasks"
        val task = JSONObject(geJSONContent(fileName))
            .getJSONArray("tasks")
            .getJSONObject(id - 1)
        return TaskData(
            task.getString("title"), task.getString("description"),
            task.getString("date")
        )
    }
}