package com.boardscards.tests

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
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
@RunWith(AndroidJUnit4ClassRunner::class)
class ListCreateTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(IntroActivity::class.java)

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