package com.boardscards.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.boardsList
import com.boardscards.robots.popUpMessage
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class AlertMessageTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(IntroActivity::class.java)

    private val boardName = "Alex"
    private val listName = "hw"
    private val deleteMessage: String = "Are you sure you want to delete hw."

    @Test
    fun verifyListDeleteAlert() {
        verifySignInSuccess()
        boards {
            selectBoard(boardName)
        }

        boardsList {
            selectList(listName)
            tapDelete(listName)
        }

        popUpMessage {
            deletePromptIsDisplayed()
            assertEquals(deleteMessage, deletePromptIsDisplayed())
        }
    }
}