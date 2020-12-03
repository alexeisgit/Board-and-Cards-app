package com.boardscards.tests


import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.boardsList
import com.boardscards.robots.login
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@LargeTest
@RunWith(AndroidJUnit4::class)

class ListsNumberTest : BaseTest() {

    fun sleep() = sleep(4000)

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)

    private val boardName = "Anna"
    private val numberOfLists = 2

    @Test

   fun verifyNumberOfLists() {
        verifySignInSuccess()

        boards {
            selectBoard(boardName)
            sleep()
        }
        boardsList {
            checkNumberOfLists(numberOfLists)
        }

        }



    }

