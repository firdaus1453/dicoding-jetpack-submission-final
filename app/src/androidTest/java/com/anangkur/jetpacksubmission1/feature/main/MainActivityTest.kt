package com.anangkur.jetpacksubmission1.feature.main

import androidx.test.rule.ActivityTestRule
import org.junit.Test
import org.junit.Rule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import com.anangkur.jetpacksubmission1.R
import com.anangkur.jetpacksubmission1.utils.ViewPagerItemCountAssertion
import org.hamcrest.Matchers

class MainActivityTest {

    @get:Rule val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun checkSliderDataIsMoreThan10(){
        onView(ViewMatchers.withId(R.id.vp_slider)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            check(ViewPagerItemCountAssertion(Matchers.greaterThan(10)))
        }
    }

    @Test
    fun checkTabLayout(){
        onView(ViewMatchers.withId(R.id.vp_main)).apply {
            check(matches(ViewMatchers.isDisplayed()))
            check(ViewPagerItemCountAssertion(Matchers.greaterThanOrEqualTo(2)))
        }
    }
}