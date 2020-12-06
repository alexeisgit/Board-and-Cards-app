package com.boardscards.tests

import androidx.test.espresso.IdlingRegistry
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.login
import com.boardscards.utils.Constants.countingIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginSuccessTest : BaseTest() {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)

//    @Before
//    fun setup() {
//        IdlingRegistry.getInstance().register(countingIdlingResource)
//
//    }
//
//    @After
//    fun teardown() {
//        IdlingRegistry.getInstance().unregister(countingIdlingResource)
//    }

    @Test

    fun verifyLoginSuccess(){
        verifySignInSuccess()
    }
//    fun verifySignInSuccess() {
//
//        login {
//            tapSignInUser()
//            enterCredentials()
//            sleep()
//            checkIfToolbarIsVisible()
//        }
//
//    }
}


