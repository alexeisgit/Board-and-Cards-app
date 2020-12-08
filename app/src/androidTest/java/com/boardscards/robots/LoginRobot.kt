package com.boardscards.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.boardscards.R
import com.boardscards.utils.waitUntilViewIsDisplayed




fun login(loginFunction: LoginRobot.() -> Unit) = LoginRobot().apply {loginFunction()}

class LoginRobot : BaseRobot() {

    private val signInButton = withId(R.id.btn_sign_in_intro)
    private val toolBarPresentMatcher = withId(R.id.toolbar_main_activity)
    private val userLogin = "ap@email.com"
    private val userPassword = "123456"
    private val wrongUserPassword = "999999"


    fun tapSignInUser(){
        onView(signInButton).perform(ViewActions.click())
        waitUntilViewIsDisplayed(withId(R.id.btn_sign_in))

    }

    fun signInErrToastCheck(){

        onView(signInButton).perform(ViewActions.click())
        onView(withId(R.id.et_email))
            .perform(ViewActions.typeText(userLogin), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.et_password))
            .perform(ViewActions.typeText(wrongUserPassword), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.btn_sign_in)).perform(ViewActions.click())




    }


    fun enterCredentials() {

            onView(withId(R.id.et_email))
                .perform(ViewActions.typeText(userLogin), ViewActions.closeSoftKeyboard())
            onView(withId(R.id.et_password))
                .perform(ViewActions.typeText(userPassword), ViewActions.closeSoftKeyboard())
            onView(withId(R.id.btn_sign_in)).perform(ViewActions.click())

        }
      fun checkIfToolbarIsVisible() = onView(toolBarPresentMatcher)
          .check(matches(isDisplayed()))

    fun signInFieldsClickable(){

        //onView(withId(R.id.et_email)).check(matches(withHint("Email")))
        onView(withId(R.id.et_email))
            .check(matches((isClickable())))
        onView(withId(R.id.et_password))
            .check(matches((isClickable())))
        onView(withId(R.id.btn_sign_in))
            .check(matches((isClickable())))




    }


}
