package com.boardscards.tests

import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.boardsList
import com.boardscards.robots.popUpMessage
import com.boardscards.robots.sleep
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import junit.framework.Assert.assertEquals


@LargeTest
@RunWith(AndroidJUnit4::class)

class AlertMessageTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)


private val boardName = "Alex"
    private val listName = "hw"
    private val deleteMessage: String = "Are you sure you want to delete hw."


   @Test

   fun verifyListDeleteAlert(){

       verifySignInSuccess()
       sleep()
       boards {
           selectBoard(boardName)
           sleep()
       }
boardsList {
    selectList(listName)
    sleep()
    tapDelete(listName)
    sleep()

}
       popUpMessage {
          deletePromptIsDisplayed()
           assertEquals(deleteMessage, deletePromptIsDisplayed())
       }


   }

}
