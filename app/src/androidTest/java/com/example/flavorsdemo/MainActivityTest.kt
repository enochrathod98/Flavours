package com.example.flavorsdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    val activityScenario = activityScenarioRule<MainActivity>()

    @Test
    fun test_textview_expected_intent_to_next_page() {
        onView(withId(R.id.tvBuildType)).perform(click())
    }
}