package com.boardscards.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.boardsList
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class ListsNumberTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(IntroActivity::class.java)

    private val boardName = "Anna"
    private val numberOfLists = 2

    @Test
    fun verifyNumberOfLists() {
        verifySignInSuccess()
        boards {
            selectBoard(boardName)
        }

        boardsList {
            checkNumberOfLists(numberOfLists)
        }
    }
}

