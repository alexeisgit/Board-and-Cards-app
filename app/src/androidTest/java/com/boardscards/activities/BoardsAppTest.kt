package com.boardscards.activities

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.robots.login
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class BoardsAppTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)

    @Test

    fun verifySignIn() {

        login {
            tapSignInUser()
            sleep()
            enterCredentials()
            sleep()
            checkIfToolbarIsVisible()
        }
    }
}
/