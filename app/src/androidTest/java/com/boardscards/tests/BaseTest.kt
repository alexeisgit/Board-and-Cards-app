package com.boardscards.tests


import androidx.test.espresso.IdlingRegistry
import com.boardscards.robots.boards
import com.boardscards.robots.login
import com.boardscards.robots.sleep
import com.boardscards.utils.Constants
import com.boardscards.utils.DateUtill
import com.schibsted.spain.barista.rule.cleardata.ClearDatabaseRule
import com.schibsted.spain.barista.rule.cleardata.ClearFilesRule
import com.schibsted.spain.barista.rule.cleardata.ClearPreferencesRule
import junit.framework.Assert
import org.junit.After
import org.junit.Before
import org.junit.Rule
import javax.inject.Inject


open class BaseTest {




    fun verifySignInSuccess() {

        login {
            tapSignInUser()
            enterCredentials()
            sleep()
            checkIfToolbarIsVisible()
        }
    }

//    @get: Rule
//    var clearPreferencesRule = ClearPreferencesRule()
//
//    @get: Rule
//    var clearDatabaseRule = ClearDatabaseRule()
//
//    @get: Rule
//    var clearFilesRule = ClearFilesRule()


    fun getExpectedReservationDate(daysToAdd: Int): String {
        val date = DateUtill.calculateDateFromToday(daysToAdd)
        var month = if (date.second >= 10) "${date.second}" else "0${date.second}"
        var day = if (date.first >= 10) "${date.first}" else "0${date.first}"
        var year = date.third
        return "$year-$month-$day"
    }


    val numberOfBoards = 3

    }


