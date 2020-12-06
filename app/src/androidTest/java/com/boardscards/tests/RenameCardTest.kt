package com.boardscards.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.boardsList
import com.boardscards.robots.cards
import com.boardscards.robots.sleep
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)

class RenameCardTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(IntroActivity::class.java)

//    @get: Rule
//    var chain = RuleChain.outerRule(clearPreferencesRule)
//        .around(clearDatabaseRule)
//        .around(clearFilesRule)
//        .around(mActivityTestRule)


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
            sleep()
            assertEquals(cardName, getCardName())

        }


    }

 @Test
    fun verifyCardIsRenamed() {

        verifySignInSuccess()
        sleep()
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