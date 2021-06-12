package com.boardscards.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class BoardNameTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(IntroActivity::class.java)
    private val boardName = "Anna"

    @Test
    fun verifyBoardTitle() {
        verifySignInSuccess()
        boards {
            selectBoard(boardName)
            boardNameIsDisplayed()
        }
    }
}