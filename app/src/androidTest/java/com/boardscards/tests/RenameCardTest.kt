package com.boardscards.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.boardsList
import com.boardscards.robots.cards
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class RenameCardTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(IntroActivity::class.java)

    private val boardName = "Catherine"
    private val listName = "Tasks"
    private val cardName = "Very Important Stuff"
    private val replaceText = "Not Very Important Stuff"

    @After
    fun resetRenameCardTest() {
        cards {
            selectCard(replaceText)
            renameCard(replaceText, cardName)
            tapUpdateButton()
            assertEquals(cardName, getCardName())
        }
    }

     @Test
     fun verifyCardIsRenamed() {
         verifySignInSuccess()
         boards {
            selectBoard(boardName)
        }

        boardsList {
            selectList(listName)
        }

        cards {
            selectCard(cardName)
            renameCard(cardName, replaceText)
            tapUpdateButton()
            assertEquals(replaceText, getCardName())
        }
    }
}