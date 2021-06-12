package com.boardscards.robots

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.boardscards.R
import com.boardscards.utils.RecyclerViewMatcher.Companion.recyclerElementCount
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.boardscards.utils.waitUntilViewIsDisplayed
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

fun boards(boardsFunction: BoardsRobot.() -> Unit) = BoardsRobot().apply(boardsFunction)

class BoardsRobot : BaseRobot() {

    private val boardsRecyclerMatcher: Matcher<View> = withId(R.id.rv_boards_list)
    private val boardTitleMatcher = withId(R.id.toolbar_task_list_activity)
    private val boardNameField: Matcher<View> = withId(R.id.et_board_name)
    private val boardImage = withId(R.id.iv_board_image)
    private val boardName = withText("Anna")
    private val memberListRecyclerMatcher: Matcher<View> = withId(R.id.rv_members_list)
    fun locateBoard(name: String) {
        onView(allOf(withId(R.id.tv_name), withText(name), isDisplayed()))
    }

    fun selectBoard(name: String) {
        onView(allOf(withId(R.id.tv_name), withText(name), isDisplayed()))
            tapBy(withText(name))
            waitUntilViewIsDisplayed(withId(R.id.toolbar_task_list_activity))
        }

        fun selectMyProfileView() {
            onView(withText("My Profile")).perform(click())
        }

        fun checkNumberOfBoards(count: Int) = onView(boardsRecyclerMatcher)
            .check(ViewAssertions.matches(recyclerElementCount(count)))

        fun getBoardTitleText(): String = getElementText(boardTitleMatcher)

        fun tapOnAddNewBoardButton() = tapBy(withId(R.id.fab_create_board))

        fun enterBoardName(boardName: String) = enterText(boardNameField, boardName)

        fun tapCreateButton() = tapBy(withId(R.id.btn_create))

        fun checkIfImageIsDisplayed() = onView(boardImage)
            .check(ViewAssertions.matches(isDisplayed()))

        fun boardNameIsDisplayed() = displayed(boardName)

        fun locateBoardCreator(creator: String, siblingName: String) {
               onView(allOf(withId(R.id.tv_created_by), withText(creator), isDisplayed()))
           (hasSibling(withText(siblingName)))
           }

        fun Displayed() = displayed(memberListRecyclerMatcher)

        fun checkMembersList(){

        val overflowMenuButton = onView(
            allOf(
                withContentDescription("More options"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar_task_list_activity),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        overflowMenuButton.perform(click())
        onView(withId(R.id.title)).perform(click())
        waitUntilViewIsDisplayed(withId(R.id.rv_members_list))
        Displayed()
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}






