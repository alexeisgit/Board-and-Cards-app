package com.boardscards.activities.robots

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.boardscards.R
import com.boardscards.utils.RecyclerViewMatcher.Companion.recyclerElementCount
import com.boardscards.utils.getText
import org.hamcrest.Matcher
import java.util.concurrent.atomic.AtomicReference

fun sleep() = Thread.sleep(2000)

fun boards(boardsFunction: BoardScreenRobot.() -> Unit) = BoardScreenRobot().apply(boardsFunction)

class BoardScreenRobot {

    private val boardsRecyclerMatcher: Matcher<View> = withId(R.id.rv_boards_list)
    private val boardTitleMatcher = withText("ad")

    fun locateBoard(name: String) {
        Espresso.onView(withId(R.id.rv_boards_list))
            .perform(actionOnItem<RecyclerView.ViewHolder>
                (ViewMatchers.hasDescendant(ViewMatchers.withText(name)), ViewActions.scrollTo()))

    }
    fun selectBoard(name: String) {
        Espresso.onView(withId(R.id.rv_boards_list))
            .perform(actionOnItem<RecyclerView.ViewHolder>
                (ViewMatchers.hasDescendant(ViewMatchers.withText(name)), ViewActions.scrollTo()))

        Espresso.onView(ViewMatchers.withText(name))
            .perform(ViewActions.click())
    }


    fun checkNumberOfBoards(count: Int) = Espresso.onView(boardsRecyclerMatcher)
        .check(ViewAssertions.matches(recyclerElementCount(count)))

    fun getBoardTitleText(): String {
        val textReference: AtomicReference<String> = AtomicReference()
        Espresso.onView(boardTitleMatcher).perform(getText(textReference))
        val actualText = textReference.toString()
        return actualText
    }

}