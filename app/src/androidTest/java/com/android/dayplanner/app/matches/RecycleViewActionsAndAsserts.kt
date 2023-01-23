//import androidx.test.espresso.ViewAction
//
//import com.adevinta.android.barista.interaction.BaristaListInteractions.findRecyclerMatcher
////import android.view.View
////import androidx.recyclerview.widget.RecyclerView
////import androidx.test.espresso.UiController
////import androidx.test.espresso.ViewAction
////import androidx.test.espresso.matcher.BoundedMatcher
////import androidx.test.espresso.matcher.ViewMatchers.*
////import org.hamcrest.CoreMatchers.allOf
////import org.hamcrest.Description
////import org.hamcrest.Matcher
////
//interface RecycleViewActionsAndAsserts {
//
//////    /**
//////     * Performs an action on a view with a given id inside a RecyclerView's item
//////     */
//    fun actionOnChildView(elementId: Int):ViewAction {
//        return ViewAction()
//
//    }
//
//////
//////    /**
//////     * checks that the matcher matcherForCheck matches a view having a given id
//////     * inside a RecyclerView's item (find its position with Matcher<View> )
//////     */
//////    fun assertOnChildView(
//////        itemMatcher: Matcher<View>,
//////        matcherForCheck: Matcher<View>, elementIdForCheck: Int
//////    ): Matcher<View> {
//////        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
//////
//////            override fun describeTo(description: Description) {
//////                description.appendText(
//////                    "check that the matcher $matcherForCheck matches a view" +
//////                            " having a given id $elementIdForCheck inside a RecyclerView's item "
//////                )
//////            }
//////
//////            override fun matchesSafely(recyclerView: RecyclerView): Boolean {
//////                val itemViewList: MutableList<View?> = mutableListOf()
//////                var itemView: View? = null
//////                recyclerView.adapter?.itemCount?.let {
//////                    for (i in 0 until it) {
//////                        recyclerView.scrollToPosition(i)
//////                        itemView = recyclerView.findViewHolderForAdapterPosition(i)?.itemView
//////                        if (hasDescendant(itemMatcher).matches(itemView)) {
//////                            itemViewList.add(itemView)
//////                        }
//////                    }
//////                }
//////                if (itemViewList.size == 0)
//////                    return false
////////                if (itemViewList.size != 1)
////////                    throw AmbiguousViewMatcherException("g")
//////                return hasDescendant(
//////                    allOf(
//////                        withId(elementIdForCheck),
//////                        matcherForCheck
//////                    )
//////                ).matches(itemViewList[0])
//////            }
//////        }
//////    }
//////
//////    fun assertItemDoesNotExist(
//////        itemMatcher: Matcher<View>
//////    ): Matcher<View> {
//////        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
//////
//////            override fun describeTo(description: Description) {
//////                description.appendText("check item does not found")
//////            }
//////
//////            override fun matchesSafely(recyclerView: RecyclerView): Boolean {
//////                val itemViewList: MutableList<View?> = mutableListOf()
//////                var itemView: View? = null
//////                recyclerView.adapter?.itemCount?.let {
//////                    for (i in 0 until it) {
//////                        recyclerView.scrollToPosition(i)
//////                        itemView = recyclerView.findViewHolderForAdapterPosition(i)?.itemView
//////                        if (hasDescendant(itemMatcher).matches(itemView)) {
//////                            itemViewList.add(itemView)
//////                        }
//////                    }
//////                }
//////                return itemViewList.size == 0
//////            }
//////        }
//////    }
//////
//////
//////    fun recyclerViewSizeMatcher(matcherSize: Int): Matcher<View> {
//////        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
//////
//////            override fun describeTo(description: Description) {
//////                description.appendText("check that the size of the list is $matcherSize")
//////            }
//////
//////            override fun matchesSafely(recyclerView: RecyclerView): Boolean {
//////                return matcherSize == recyclerView.adapter?.itemCount
//////            }
//////        }
//////    }
//}