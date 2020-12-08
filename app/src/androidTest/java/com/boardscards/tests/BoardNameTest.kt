package com.boardscards.tests

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)

class BoardNameTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)
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