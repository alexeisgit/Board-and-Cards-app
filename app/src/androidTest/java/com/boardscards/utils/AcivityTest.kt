package com.boardscards.utils

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import junit.framework.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(IntroActivity::class.java)


    @Test

    fun verifyBoardTitleActivity() {

        boards {
            selectBoard("ad")
            sleep()
            Assert.assertEquals("ad", getBoardTitleText())

        }


    }
}