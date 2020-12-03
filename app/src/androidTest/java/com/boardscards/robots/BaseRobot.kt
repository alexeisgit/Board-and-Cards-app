package com.boardscards.robots

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.boardscards.utils.getText
import org.hamcrest.Matcher
import java.util.concurrent.atomic.AtomicReference


open class BaseRobot {

    fun sleep() = Thread.sleep(5000)

    fun enterText(matcher: Matcher<View>, text: String) = Espresso.onView(matcher)
        .perform(ViewActions.typeText(text))
        .perform(ViewActions.closeSoftKeyboard())

    fun tapBy(matcher: Matcher<View>) = Espresso.onView(matcher).perform(ViewActions.click())


    fun getElementText(elementMatcher: Matcher<View>): String {
        val textReference: AtomicReference<String> = AtomicReference()
        Espresso.onView(elementMatcher).perform(getText(textReference))
        return textReference.toString()


    }

    fun displayed(matcher: Matcher<View>) = Espresso.onView(matcher)
        .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


}
