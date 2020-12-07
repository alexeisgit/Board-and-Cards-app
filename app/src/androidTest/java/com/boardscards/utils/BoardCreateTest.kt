package com.boardscards.utils

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.sleep
import com.boardscards.tests.BaseTest
import org.junit.After

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)

class BoardCreateTest : BaseTest() {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)
    private val enteredBoardName = "John"
    @After


    @Test

    fun verifyNewBoardCreated() {
      verifySignInSuccess()
        sleep()
        boards {
            tapOnAddNewBoardButton()
            enterBoardName(enteredBoardName)
            tapCreateButton()
            sleep()
        }

        boards {
            locateBoard(enteredBoardName)

        }

        }


    }

