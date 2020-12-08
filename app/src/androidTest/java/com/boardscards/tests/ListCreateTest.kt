package com.boardscards.tests

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.R
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.boardsList
import org.hamcrest.Matcher
import org.junit.After

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)

class ListCreateTest : BaseTest() {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)
    private val taskListMatcher: Matcher<View> = ViewMatchers.withId(R.id.et_task_list_name)
    private val enteredBoardName = "Joe"
    private val createdListName = "Election2020"

    @After

    fun resetListCreateTest(){
     boardsList {
         deleteTestList(createdListName)
     }

    }


    @Test

    fun verifyNewListCreated() {
        verifySignInSuccess()
        boards {

            selectBoard(enteredBoardName)
        }
        boardsList {
            tapOnAddList()
            enterText(taskListMatcher, createdListName)
            hitDoneButton()
            createdListDisplayed(createdListName)


        }

    }

}