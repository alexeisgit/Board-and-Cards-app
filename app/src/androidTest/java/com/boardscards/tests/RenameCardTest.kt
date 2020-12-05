package com.boardscards.tests

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.boardsList
import com.boardscards.robots.cards
import com.boardscards.robots.sleep
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)

class RenameCardTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)

    private val boardName = "Catherine"
    private val listName = "Tasks"
    private val cardName = "Very Important Stuff"
    private val replaceText = "Not Very Important Stuff"


 @Test
    fun verifyCardIsRenamed() {

        verifySignInSuccess()
        sleep()
        boards {
            selectBoard(boardName)
            sleep()
        }
        boardsList {
            selectList(listName)
            sleep()
        }
        cards {
            selectCard(cardName)
            sleep()
            renameCard(cardName,replaceText)
            sleep()
            tapUpdateButton()
            sleep()
            assertEquals(replaceText,getCardName())


        }
    }
}