package com.android.dayplanner.app.screens

import com.adevinta.android.barista.assertion.BaristaCheckedAssertions.assertChecked
import com.adevinta.android.barista.assertion.BaristaCheckedAssertions.assertUnchecked
import com.adevinta.android.barista.assertion.BaristaListAssertions.assertDisplayedAtPosition
import com.adevinta.android.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount
import com.adevinta.android.barista.interaction.BaristaListInteractions.clickListItem
import com.adevinta.android.barista.interaction.BaristaListInteractions.clickListItemChild
import com.adevinta.android.barista.interaction.BaristaListInteractions.scrollListToPosition
import com.android.dayplanner.app.R

object ListOfTasksBasic {

    private val titleTextField: Int
        get() = R.id.textView_title
    private val descriptionTextField: Int
        get() = R.id.textView_description
    private val dateTextField: Int
        get() = R.id.textView_date
    private val deleteTaskButton: Int
        get() = R.id.imageView_delete
    private val completeTaskCheckBox: Int
        get() = R.id.checkBox

    fun actionClickOnTheCheckBoxAtPosition(recyclerViewId: Int, elementPosition: Int) {
        clickListItemChild(recyclerViewId, elementPosition, completeTaskCheckBox)
    }

    fun actionClickOnDeleteButtonAtPosition(recyclerViewId: Int, elementPosition: Int) {
        clickListItemChild(recyclerViewId, elementPosition, deleteTaskButton)
    }

    fun actionClickOnTheTaskAtPosition(recyclerViewId: Int, elementPosition: Int) {
        clickListItem(recyclerViewId, elementPosition)
    }

    fun assertDisplayedTitleAtPosition(
        recyclerViewId: Int, elementPosition: Int, textTitle: String
    ) {
        assertDisplayedAtPosition(recyclerViewId, elementPosition, titleTextField, textTitle)
    }

    fun assertDisplayedDescriptionAtPosition(
        recyclerViewId: Int, elementPosition: Int, textDescription: String
    ) {
        assertDisplayedAtPosition(
            recyclerViewId, elementPosition, descriptionTextField, textDescription
        )
    }

    fun assertDisplayedDateAtPosition(
        recyclerViewId: Int, elementPosition: Int, textDate: String
    ) {
        assertDisplayedAtPosition(recyclerViewId, elementPosition, dateTextField, textDate)
    }

    fun assertTheStatusIsCheckedAtPosition(recyclerViewId: Int, elementPosition: Int) {
        scrollListToPosition(recyclerViewId, elementPosition)
        assertChecked(completeTaskCheckBox)
    }

    fun assertTheStatusIsNotCheckedAtPosition(recyclerViewId: Int, elementPosition: Int) {
        scrollListToPosition(recyclerViewId, elementPosition)
        assertUnchecked(completeTaskCheckBox)
    }

    fun assertListItemCount(recyclerViewId: Int, itemCount: Int) {
        assertRecyclerViewItemCount(recyclerViewId, itemCount);
    }
}