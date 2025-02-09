package com.boardscards.tests


import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.boardscards.R
import com.boardscards.robots.login
import com.boardscards.utils.DateUtill
import com.boardscards.utils.waitUntilViewIsDisplayed
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
open class BaseTest {

    fun verifySignInSuccess() {
        login {
            tapSignInUser()
            enterCredentials()
            waitUntilViewIsDisplayed(withId(R.id.rv_boards_list))
            checkIfToolbarIsVisible()
        }
    }

    fun getExpectedReservationDate(daysToAdd: Int): String {
        val date = DateUtill.calculateDateFromToday(daysToAdd)
        var month = if (date.second >= 10) "${date.second}" else "0${date.second}"
        var day = if (date.first >= 10) "${date.first}" else "0${date.first}"
        var year = date.third
        return "$year-$month-$day"
    }
}
