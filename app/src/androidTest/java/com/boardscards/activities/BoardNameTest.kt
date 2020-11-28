package com.boardscards.activities

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.robots.boards
import com.boardscards.activities.robots.login
import com.boardscards.activities.robots.sleep
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import junit.framework.Assert.assertEquals

@LargeTest
@RunWith(AndroidJUnit4::class)

class BoardNameTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)

    private val boardName = "ad"
    @Test

    fun verifyBoardTitle() {
        login {
            tapSignInUser()
            enterCredentials()
            sleep()
            checkIfToolbarIsVisible()
            sleep()
        }

        boards {
            selectBoard(boardName)
            sleep()
            assertEquals(boardName, getBoardTitleText())

        }


    }




}