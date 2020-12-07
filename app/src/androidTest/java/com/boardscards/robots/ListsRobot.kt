package com.boardscards.robots

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.boardscards.R
import com.boardscards.utils.ChildViewAction
import com.boardscards.utils.RecyclerViewMatcher
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf


fun boardsList(listFunction: ListsRobot.() -> Unit) =
      ListsRobot().apply(listFunction)

class ListsRobot : BaseRobot() {

      private val listRecyclerMatcher: Matcher<View> = withId(R.id.rv_task_list)
      private val deleteBtn = withId(R.id.ib_delete_list)

      fun selectLis(name: String) {
            onView(withId(R.id.rv_task_list))
                  .perform(actionOnItem<RecyclerView.ViewHolder>
                        (ViewMatchers.hasDescendant(withText(name)), ViewActions.scrollTo()))

            onView(withText(name))
                  .perform(click())
      }

      fun locateList(name: String) {

            onView(
                  Matchers.allOf(
                        withId(R.id.rv_task_list),
                        withText(name),
                        ViewMatchers.isDisplayed()
                  )
            )
      }

      fun selectCard(name: String) {

            onView(allOf(withId(R.id.tv_task_list_title), withText(name), ViewMatchers.isDisplayed()))

            tapBy(withText(name))


      }

            fun selectList(name: String) {

                  onView(allOf(withId(R.id.rv_task_list), withText(name), ViewMatchers.isDisplayed()))

                  tapBy(withText(name))


            }

      fun tapDelete(itemName: String) {
            onView(withId(R.id.rv_task_list))
                  .perform(
                        RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>
                        (ViewMatchers.hasDescendant(withText(itemName)), ChildViewAction(R.id.ib_delete_list, click())))
      }


      fun checkNumberOfLists(count: Int) = Espresso.onView(listRecyclerMatcher)
            .check(ViewAssertions.matches(RecyclerViewMatcher.recyclerElementCount(count)))




}
