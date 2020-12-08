package com.boardscards.robots


import androidx.test.espresso.matcher.ViewMatchers.withText



fun popUpMessage(popUpFunction: PopUpRobot.() -> Unit) = PopUpRobot().apply { popUpFunction() }

class PopUpRobot : BaseRobot() {
private val deleteMessage = withText("Are you sure you want to delete hw.")


    fun deletePromptIsDisplayed(): String = getElementText(deleteMessage)


}