package com.boardscards.tests

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.boardsList
import com.boardscards.robots.cards
import com.boardscards.robots.sleep
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import junit.framework.Assert.assertEquals


@LargeTest
@RunWith(AndroidJUnit4::class)

class DueDateTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)

    private val boardName = "Peter"
    private val taskName = "Tasks"
    private val cardName = "Problem1"
    private val expectedDueDate = "08/12/2020"

    @Test

    fun verifySetDueDate() {

        verifySignInSuccess()
        sleep()
        boards {
            selectBoard(boardName)

        }
        boardsList {
            selectList(taskName)



        }
        cards {
            selectCard(cardName)
            sleep()
            tapDueDateField()
            selectDate(8,12,2020)
            confirmOK()
            tapUpdateButton()
            selectCard(cardName)
            locateDateView(expectedDueDate)
            assertEquals(expectedDueDate, getDateString())



        }
    }
}