package com.example.cbcnewsapp.ui.fragments

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.cbcnewsapp.R
import com.example.cbcnewsapp.ui.NewsActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

@LargeTest
class BreakingNewsFragmentTest {
    @get: Rule
    val activityRule = ActivityScenarioRule(NewsActivity::class.java)



    /*
    * Recycler view comes into view
    * */
    @Test
    fun test_isBreakingnewsFragment_onAppLaunch() {
        Espresso.onView(ViewMatchers.withId(R.id.rvBreakingNews))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testViewDisplay() {
        Espresso.onView(ViewMatchers.withId(R.id.breakingNewsFragment2))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.ivArticleImage))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tvDescription))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tvTitle))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tvPublishedAt))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}