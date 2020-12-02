package com.boardscards.robots

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.boardscards.R



fun boardsList(listFunction: BoardsListRobot.() -> Unit) =
      BoardsListRobot().apply(listFunction)

class BoardsListRobot {

      fun selectList(name: String) {
            onView(withId(R.id.rv_task_list))
                  .perform(actionOnItem<RecyclerView.ViewHolder>
                        (ViewMatchers.hasDescendant(withText(name)), ViewActions.scrollTo()))

            onView(withText(name))
                  .perform(click())
      }
}
//
//import androidx.recyclerview.widget.RecyclerView
//import androidx.test.espresso.Espresso.onView
//import androidx.test.espresso.action.ViewActions.click
//import androidx.test.espresso.action.ViewActions.scrollTo
//import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
//import androidx.test.espresso.matcher.ViewMatchers.withId
//import androidx.test.espresso.matcher.ViewMatchers.withText
//import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
//import com.boardscards.R
//
//
//fun restaurantList(listFunction: RestaurantListRobot.() -> Unit) =
//      RestaurantListRobot().apply(listFunction)
//
//class RestaurantListRobot {
//      fun selectRestaurant(name: String) {
//            onView(withId(R.id.restaurantRecycler))
//                  .perform(actionOnItem<RecyclerView.ViewHolder>
//                        (hasDescendant(withText(name)), scrollTo()))
//
//            onView(withText(name))
//                  .perform(click())
//      }
//}
