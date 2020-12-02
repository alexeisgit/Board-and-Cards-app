package com.boardscards.tests

import androidx.test.espresso.IdlingRegistry
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.sleep
import com.boardscards.utils.Constants
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before

@LargeTest
@RunWith(AndroidJUnit4::class)

class BoardNameTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)

//    @Before
//    fun setup() {
//        IdlingRegistry.getInstance().register(Constants.countingIdlingResource)
//
//    }
//
//    @After
//    fun teardown() {
//        IdlingRegistry.getInstance().unregister(Constants.countingIdlingResource)
//    }
    @Test

    fun verifyBoardTitle() {
        verifySignInSuccess()
        sleep()

        boards {
            selectBoard(boardName)
            sleep()
            assertEquals(boardName, getBoardTitleText())

        }


    }



}