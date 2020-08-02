package com.padcx.movieapp_hhh

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padcx.movieapp_hhh.activities.MainActivity
import com.padcx.movieapp_hhh.data.vos.ShowCaseVO
import com.padcx.movieapp_hhh.viewHolders.PopularFilmViewHolder
import com.padcx.movieapp_hhh.viewHolders.ShowCaseViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToTheMovieDetailTest {

    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
        fun goDetailMovieView(){

        onView(withId(R.id.rcBestMovie))
            .perform(RecyclerViewActions.actionOnItemAtPosition<PopularFilmViewHolder>(0,
                ViewActions.click()))

        onView(withId(R.id.movie_poster_image))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }



    @Test
    fun goToShowCaseDetail(){

        onView(withId(R.id.rcShowCase))
            .perform(scrollTo())

        onView(withId(R.id.rcShowCase))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ShowCaseViewHolder>(0,ViewActions.click()))

        onView(withId(R.id.movie_poster_image))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}