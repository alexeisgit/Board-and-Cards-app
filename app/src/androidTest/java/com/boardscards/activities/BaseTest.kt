package com.boardscards.activities

import com.boardscards.activities.robots.login

open class BaseTest {

    fun verifySignInSuccess() {

        login {
            tapSignInUser()
            enterCredentials()
            sleep()
            checkIfToolbarIsVisible()
        }

    }

    val boardName = "ad"
    val numberOfBoards = 2

}