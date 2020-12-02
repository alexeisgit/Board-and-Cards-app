package com.boardscards.robots

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.boardscards.R
import com.boardscards.utils.RecyclerViewMatcher.Companion.recyclerElementCount
import org.hamcrest.Matcher

fun sleep() = Thread.sleep(2000)

fun boards(boardsFunction: BoardScreenRobot.() -> Unit) = BoardScreenRobot().apply(boardsFunction)

class BoardScreenRobot : BaseRobot() {

    private val boardsRecyclerMatcher: Matcher<View> = withId(R.id.rv_boards_list)
    private val boardTitleMatcher = withText("Joe")
    private val boardNameField: Matcher<View> = withId(R.id.et_board_name)

    fun locateBoard(name: String) {
        Espresso.onView(withId(R.id.rv_boards_list))
            .perform(actionOnItem<RecyclerView.ViewHolder>
                (ViewMatchers.hasDescendant(withText(name))
                , ViewActions.scrollTo()))


    }
    fun selectBoard(name: String) {
        Espresso.onView(withId(R.id.rv_boards_list))
            .perform(actionOnItem<RecyclerView.ViewHolder>
                (ViewMatchers.hasDescendant(withText(name)), ViewActions.scrollTo()))

        Espresso.onView(withText(name))
            .perform(ViewActions.click())
    }


    fun checkNumberOfBoards(count: Int) = Espresso.onView(boardsRecyclerMatcher)
        .check(ViewAssertions.matches(recyclerElementCount(count)))


    fun getBoardTitleText(): String = getElementText(boardTitleMatcher)

    fun tapOnAddNewBoardButton() = tapBy(withId(R.id.fab_create_board))

    fun enterBoardName(boardName: String) = enterText(boardNameField,boardName)

    fun tapCreateButton() = tapBy(withId(R.id.btn_create))



}