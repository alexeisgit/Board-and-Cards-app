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
import com.boardscards.utils.waitUntilViewIsDisplayed
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf


fun boardsList(listFunction: ListsRobot.() -> Unit) =
      ListsRobot().apply(listFunction)

class ListsRobot : BaseRobot() {

//      private val listRecyclerMatcher: Matcher<View> = withId(R.id.tv_task_list_title)
       private val listRecyclerMatcher: Matcher<View> = withId(R.id.rv_task_list)
      private val addListMatcher: Matcher<View> = withId(R.id.tv_add_task_list)
      private val hitDoneButtonMatcher: Matcher<View> = withId(R.id.ib_done_list_name)
      private val tapAlerYesButton = withText("Yes")



      fun createdListDisplayed (listName: String){
            onView(
                  allOf(withId(R.id.tv_task_list_title), withText(listName), ViewMatchers.isDisplayed()))

      }
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


      fun checkNumberOfLists(count: Int) = onView(listRecyclerMatcher)
            .check(ViewAssertions.matches(RecyclerViewMatcher.recyclerElementCount(count)))

      fun createList(){
            onView(withId(R.id.tv_add_task_list)).perform(click())


      }



   fun tapOnAddList() = tapBy(addListMatcher)

      fun hitDoneButton() {
            tapBy(hitDoneButtonMatcher)
            waitUntilViewIsDisplayed(withId(R.id.rv_task_list))
      }

   fun deleteTestList(itemName: String) {
         onView(withId(R.id.rv_task_list))
               .perform(
                     RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>
                           (ViewMatchers.hasDescendant(withText(itemName)), ChildViewAction(R.id.ib_delete_list, click())))
         tapBy(tapAlerYesButton)
   }


      }



