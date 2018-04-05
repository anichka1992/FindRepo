package com.example.annastasyshena.findrepo.Screens

import android.support.test.espresso.*
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.*
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.uiautomator.UiSelector
import com.example.annastasyshena.findrepo.R.id.repoListView
import com.example.annastasyshena.findrepo.globalTimeout
import junit.framework.Assert

/**
 * Created by annastasyshena on 3/23/18.
 */
class SearchResultScreen : BaseScreen() {

    private val listObject = uiDevice.findObject(UiSelector().resourceId("com.example.annastasyshena.findrepo:id/repoListView"))
    private val urlObject = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar"))

    init {
        Assert.assertTrue("Expected elements are not displayed", listObject.waitForExists(globalTimeout))
    }

    fun getTextFromUrl() = urlObject.text

    fun clickListItem(id: Int, position: Int) {
        Espresso.onData(anything())
                .inAdapterView(allOf(withId(id)))
                .atPosition(position).perform(click())
    }

    fun snackbarAssertion(text: String): ViewInteraction =
            onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(text)))
                    .check(matches(isDisplayed()))
}