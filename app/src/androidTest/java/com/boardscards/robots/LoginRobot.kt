package com.boardscards.robots

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.boardscards.R



fun login(loginFunction: LoginRobot.() -> Unit) = LoginRobot().apply {loginFunction()}

class LoginRobot {

    private val signInButton = withId(R.id.btn_sign_in_intro)
    private val toolBarPresentMatcher = withId(R.id.toolbar_main_activity)
    private val userLogin = "ap@email.com"
    private val userPassword = "123456"

    fun tapSignInUser(){
        Espresso.onView(signInButton).perform(ViewActions.click())


    }
    fun sleep() = Thread.sleep(5000)

    fun enterCredentials() {

            Espresso.onView(withId(R.id.et_email))
                .perform(ViewActions.typeText(userLogin), ViewActions.closeSoftKeyboard())
            Espresso.onView(withId(R.id.et_password))
                .perform(ViewActions.typeText(userPassword), ViewActions.closeSoftKeyboard())
            Espresso.onView(withId(R.id.btn_sign_in)).perform(ViewActions.click())

        }
      fun checkIfToolbarIsVisible() = Espresso.onView(toolBarPresentMatcher)
          .check(matches(ViewMatchers.isDisplayed()))


    }
