package com.boardscards.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

class RecyclerViewItemMatcher private constructor(val position: Int, val matcher: Matcher<View>)
    : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
    override fun describeTo(description: Description?) {
        description?.appendText("has item at position $position : ")
        matcher.describeTo(description)
    }

    override fun matchesSafely(item: RecyclerView?): Boolean {
        val viewHolder = item?.findViewHolderForAdapterPosition(position)
        return matcher.matches(viewHolder?.itemView)
    }

    companion object {
        fun hasItemAtPosition(position: Int, matcher: Matcher<View>):
                RecyclerViewItemMatcher = RecyclerViewItemMatcher(position, matcher)
    }
}
