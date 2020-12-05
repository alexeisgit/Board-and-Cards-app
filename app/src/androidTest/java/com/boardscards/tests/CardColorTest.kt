package com.boardscards.tests

import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.boardsList
import com.boardscards.robots.sleep
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)

class CardColorTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)

    private val boardName = "Peter"
    private val cardName = "Problem1"

    @Test

    fun verifyCardColor() {


        verifySignInSuccess()
        sleep()
        boards {
            selectBoard(boardName)
            sleep()
        }

boardsList {
    selectCard(cardName)
}









    }
}