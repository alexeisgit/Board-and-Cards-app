package com.boardscards.activities

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.robots.boards
import com.boardscards.activities.robots.boardsList
import com.boardscards.activities.robots.login
import com.boardscards.activities.robots.sleep
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.concurrent.thread

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginSuccessTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)

    @Test

    fun verifySignInSuccess() {

        login {
            tapSignInUser()
            enterCredentials()
            sleep()
            checkIfToolbarIsVisible()
        }

    }
}


