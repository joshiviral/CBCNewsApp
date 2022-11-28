package com.example.cbcnewsapp.ui


import android.app.PendingIntent.getActivity
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.cbcnewsapp.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@LargeTest
class NewsActivityTest {

    @Test
    fun test_isActivityInView(){
        val activityScenario = ActivityScenario.launch(NewsActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

}