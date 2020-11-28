package com.boardscards.activities


import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.robots.boards
import com.boardscards.activities.robots.login
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@LargeTest
@RunWith(AndroidJUnit4::class)

class BoardsNumberTest {

    fun sleep() = sleep(4000)

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)

    private val numberOfBoards = 2
    private val boardName = "ad"

    @Test

   fun verifyNumberOfBoards() {

        login {
            tapSignInUser()
            enterCredentials()
            sleep()
            checkIfToolbarIsVisible()

        }
        boards {
            locateBoard(boardName)
        }
        boards {
            checkNumberOfBoards(numberOfBoards)
        }



    }

}