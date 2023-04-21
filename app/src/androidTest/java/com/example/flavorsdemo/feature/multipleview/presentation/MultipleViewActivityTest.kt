package com.example.flavorsdemo.feature.multipleview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.flavorsdemo.R
import com.example.flavorsdemo.feature.multipleview.domain.entity.MultipleViewEntity
import com.example.flavorsdemo.feature.multipleview.presentation.multipleviewVO.MultipleViewVO
import com.example.flavorsdemo.feature.multipleview.presentation.multipleviewVO.viewmodel.MultipleViewModel
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import org.hamcrest.core.StringEndsWith.endsWith
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MultipleViewActivityTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val activityScenario =
        ActivityScenarioRule(MultipleViewActivity::class.java)



    @BindValue
    @JvmField
    val viewModel = mockk<MultipleViewModel>(relaxed = true)


    fun <T : ViewModel> createViewModelFor(model: T): ViewModelProvider.Factory =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(model.javaClass)) {
                    return model as T
                }
                throw IllegalArgumentException("unexpected model class $modelClass")
            }
        }

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        hiltRule.inject()
    }

    @Test
    fun test_title_textview_expected_correct_title() {
        onView(withId(R.id.textTitleTv)).perform(ViewActions.typeText("his msg is From Text Type"))
        onView(withText(endsWith("This msg is From Text Type"))).check(matches(isDisplayed()));
        //  onView(withId(R.id.textTitleTv)).check(matches(withText("This msg is From Text Type")))
    }

    @Test
    fun test_progressbar_visibility_whenProgress() {
        every { viewModel.dataView.value } returns MultipleViewVO.Progress

        onView(withId(R.id.progress)).check(matches(isDisplayed()))
    }

    @Test
    fun test_progressbar_visibility_whenLoaded() {
        every { viewModel.dataView.value } returns MultipleViewVO.Loaded(
            listOf(
                MultipleViewEntity.TextData(
                    text = "This msg is From Text Type",
                    type = "Text"
                )
            )
        )
        onView(withId(R.id.progress)).check(matches(withEffectiveVisibility(Visibility.GONE)))
    }

    @Test
    fun test_progressbar_visibility_whenError() {
        every { viewModel.dataView.value } returns MultipleViewVO.Error("Not found")
        onView(withId(R.id.progress)).check(matches(isDisplayed()))
    }
}