package com.boardscards.robots

import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.boardscards.R
import com.boardscards.utils.ChildViewAction
import com.boardscards.utils.DateUtill
import com.boardscards.utils.waitUntilViewIsDisplayed
import com.schibsted.spain.barista.internal.performAction
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.anyOf
import org.hamcrest.TypeSafeMatcher

fun cards(CardsFunction: CardsRobot.() -> Unit) =
    CardsRobot().apply { CardsFunction() }

class CardsRobot : BaseRobot() {

    private val addMemberButtonMatcher: Matcher<View> = withId(R.id.iv_add_member)
    private val selectedMemberRecyclerView = withId(R.id.rv_selected_members_list)
    private val dueDateFieldMatcher: Matcher<View> = withId(R.id.tv_select_due_date)
    private val updateButtonMatcher: Matcher<View> = withId(R.id.btn_update_card_details)
    //private val dueDateTextMatcher: Matcher<View> = withText("07/12/2020")
    private val dueDateTextMatcher: Matcher<View> = withId(R.id.tv_select_due_date)


    private val cardNameMatcher: Matcher<View> = withId(R.id.tv_card_name)


    fun selectReservationDate(daysToAdd: Int) {
        val date = DateUtill.calculateDateFromToday(daysToAdd)
        selectDate(date.first, date.second, date.third)
    }

    fun getDateString(): String = getElementText(dueDateTextMatcher)

    fun getCardName(): String = getElementText(cardNameMatcher)

    fun locateDateView(date: String) {

        onView(
            Matchers.allOf(
                withId(R.id.tv_select_due_date),
                withText(date),
                ViewMatchers.isDisplayed()
            )
        )


    }


//    fun clickAdd() {
//        activity = mActivityTestRule.launchActivity(startingIntent);
//    onView(withId(R.id.recyclerView))
//    .perform(RecyclerViewActions.scrollToPosition(activity.recyclerView.getAdapter().getItemCount() - 1))
//        .perform(click())
//}

    fun resetTest(){





    }
    fun confirmOK() {
        onView(
            anyOf(
                withText(android.R.string.ok),
                withId(android.R.id.button1)
            )
        )
            .inRoot(isDialog())
            .perform(click())


    }

    fun tapUpdateButton() {
        tapBy(updateButtonMatcher)

        waitUntilViewIsDisplayed(ViewMatchers.withId(R.id.rv_task_list))
    }

    fun renameCard(cardName: String, replaceText: String) {


        onView(Matchers.allOf(withId(R.id.et_name_card_details), withText(cardName)))
            .perform(replaceText(replaceText))

//            , ViewMatchers.isDisplayed()))


    }


//fun setDate() {
//    onView(withId(R.id.datePicker)).perform(PickerActions.setDate(2020, 12, 7));
//}


    fun selectCard(name: String) {

        Espresso.onView(
            Matchers.allOf(
                withId(R.id.tv_card_name),
                ViewMatchers.withText(name),
                ViewMatchers.isDisplayed()
            )
        )

        tapBy(ViewMatchers.withText(name))
        waitUntilViewIsDisplayed(ViewMatchers.withId(R.id.et_name_card_details))

    }

    fun selectMember(email: String) {
        Espresso.onView(
            Matchers.allOf(
                withId(R.id.tv_member_email),
                ViewMatchers.withText(email),
                ViewMatchers.isDisplayed()
            )
        )

        //tapBy(ViewMatchers.withText(email))
    }

    fun tapDueDateField() = tapBy(dueDateFieldMatcher)

    fun tapAddButton() = tapBy(addMemberButtonMatcher)

    fun tapAddNewMemberButton(resourceName: String) {
        Espresso.onView(selectedMemberRecyclerView)

            .perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>
                    (
                    ViewMatchers.hasDescendant(ViewMatchers.withResourceName(resourceName)),
//                    ChildViewAction(R.id.iv_add_member,
                    ViewActions.click()
                )
            )
    }


}


