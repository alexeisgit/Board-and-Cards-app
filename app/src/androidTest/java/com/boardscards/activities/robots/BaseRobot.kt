package com.boardscards.activities.robots

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import com.boardscards.utils.getText
import org.hamcrest.Matcher
import java.util.concurrent.atomic.AtomicReference


open class BaseRobot {

    fun sleep() = Thread.sleep(2000)

    fun enterText(matcher: Matcher<View>, text: String) = Espresso.onView(matcher)
        .perform(ViewActions.typeText(text))
        .perform(ViewActions.closeSoftKeyboard())

    fun tapBy(matcher: Matcher<View>) = Espresso.onView(matcher).perform(ViewActions.click())

    fun getElementText(elementMatcher: Matcher<View>): String {
        val textReference: AtomicReference<String> = AtomicReference()
        Espresso.onView(elementMatcher).perform(getText(textReference))
        return textReference.toString()


    }


}
