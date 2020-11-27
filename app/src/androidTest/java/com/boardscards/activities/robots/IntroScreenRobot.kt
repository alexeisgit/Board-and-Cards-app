package com.boardscards.activities.robots

import androidx.test.espresso.Espresso
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.boardscards.R



fun login(loginFunction: LoginRobot.() -> Unit) = LoginRobot().apply {loginFunction()}

class LoginRobot {

    private val signInButton = ViewMatchers.withId(R.id.btn_sign_in_intro)
    private val toolBarPresentMatcher = withId(R.id.toolbar_main_activity)

    fun tapSignInUser(){
        Espresso.onView(signInButton).perform(ViewActions.click())


    }
    fun sleep() = Thread.sleep(2000)

    fun enterCredentials() {
        // Login if it is on the LoginActivity
        //try {
            // Type email and password
            Espresso.onView(ViewMatchers.withId(R.id.et_email))
                .perform(ViewActions.typeText("ap@email.com"), ViewActions.closeSoftKeyboard())
            Espresso.onView(ViewMatchers.withId(R.id.et_password))
                .perform(ViewActions.typeText("123456"), ViewActions.closeSoftKeyboard())

            // Click login button
            Espresso.onView(ViewMatchers.withId(R.id.btn_sign_in)).perform(ViewActions.click())
     //   } catch (e: NoMatchingViewException) {
            //view not displayed logic
        }
      fun checkIfToolbarIsVisible() = Espresso.onView(toolBarPresentMatcher)
          .check(matches(ViewMatchers.isDisplayed()))


    }
