package com.boardscards.tests

import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.boardscards.R
import com.boardscards.activities.IntroActivity
import com.boardscards.robots.boards
import com.boardscards.robots.boardsList
import com.boardscards.robots.cards
import com.boardscards.robots.sleep
import kotlinx.android.synthetic.main.activity_card_details.view.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)

class AddMemberTest : BaseTest() {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(IntroActivity::class.java)


    private val boardName = "Peter"
    private val taskName = "Tasks"
    private val cardName = "Problem1"
    private val memberEmail = "dan@email.com"
    private val elementMatcher = withId(R.id.rv_selected_members_list)

    @Test


    fun verifyAssignMemberToProject() {

        verifySignInSuccess()
        sleep()
        boards {
            selectBoard(boardName)
            sleep()
        }
        boardsList {
            selectList(taskName)
            sleep()


        }
        cards {
            selectCard(cardName)
            sleep()
            getRecyclerViewItemsCount(elementMatcher)


      //tapAddButton()
            //tapAddNewMemberButton("ic_add_member")
//            sleep()
//            selectMember(memberEmail)
//            sleep()
//            updateCard()
//            checkAssignedMember()



        }


    }
}