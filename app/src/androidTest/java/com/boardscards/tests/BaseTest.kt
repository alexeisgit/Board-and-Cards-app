package com.boardscards.tests


import com.boardscards.robots.boards
import com.boardscards.robots.login
import com.boardscards.robots.sleep
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


    val numberOfBoards = 3

    }


