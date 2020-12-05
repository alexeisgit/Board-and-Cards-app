package com.boardscards.tests


import com.boardscards.robots.boards
import com.boardscards.robots.login
import com.boardscards.robots.sleep
import com.boardscards.utils.DateUtill
import junit.framework.Assert


open class BaseTest {


    fun verifySignInSuccess() {

        login {
            tapSignInUser()
            enterCredentials()
            sleep()
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


    val numberOfBoards = 3

    }


