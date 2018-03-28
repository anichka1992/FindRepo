package com.example.annastasyshena.findrepo.Screens

import android.support.test.espresso.*
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.*
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.annastasyshena.findrepo.BaseTest
import com.example.annastasyshena.findrepo.R.id.*


/**
 * Created by annastasyshena on 3/23/18.
 */
class SearchResultScreen : BaseTest() {


   /// init {
   ///     Assert.assertTrue("Expected elements are not displayed", onView(withId(repoListView)).check(matches(isDisplayed())
   // }

    fun anna(id: Int): Boolean {
       onView(withId(id)).check(matches(isDisplayed()))
        return true
}




    fun matchText(viewInteraction: DataInteraction, text: String): ViewInteraction = viewInteraction
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))


    fun clickListItem(id: Int, position: Int) {
        Espresso.onData(CoreMatchers.anything())
                .inAdapterView(CoreMatchers.allOf(ViewMatchers.withId(id)))
                .atPosition(position).perform(ViewActions.click())
    }

    fun verify(id: Int, text: String) {
        Espresso.onData(CoreMatchers.anything())
                .inAdapterView(CoreMatchers.anyOf(ViewMatchers.withId(id)))
                .check(matches(withText(containsString(text))))
    }

    fun anna(text: String) = Espresso.onView(ViewMatchers.withId(repoTextView)).check(ViewAssertions.matches(ViewMatchers.withText(text)))



    fun snackbarAssertion(text: String) : ViewInteraction =
            onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(text)))
                    .check(matches(isDisplayed()))

   fun wait(milliseconds: Long): ViewInteraction = Espresso.onView(isRoot()).perform(waitFor(milliseconds))

}



