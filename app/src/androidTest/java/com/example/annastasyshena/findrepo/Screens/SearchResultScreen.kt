package com.example.annastasyshena.findrepo.Screens

import android.support.test.espresso.*
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.*
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.uiautomator.UiSelector
import com.example.annastasyshena.findrepo.globalTimeout
import junit.framework.Assert

/**
 * Created by annastasyshena on 3/23/18.
 */
class SearchResultScreen : BaseScreen() {

    private val listObject = uiDevice.findObject(UiSelector().resourceId("com.example.annastasyshena.findrepo:id/repoTextView"))
    private val snackBar = uiDevice.findObject(UiSelector().resourceId("com.example.annastasyshena.findrepo:id/snackbar_text"))
    private val urlObject = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar"))

    fun viewExist() {
        Assert.assertTrue("Expected elements are not displayed", listObject.waitForExists(globalTimeout))
    }

    fun existOfSnackBar() {
        Assert.assertTrue("Expected elements are not displayed", snackBar.waitForExists(2000))
    }

    fun getTextFromUrl() = urlObject.text

    fun clickListItem(id: Int, position: Int) {
        Espresso.onData(anything())
                .inAdapterView(anyOf(withId(id)))
                .atPosition(position).perform(click())
    }

    fun snackbarAssertion(text: String): ViewInteraction =
            onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(text)))
                    .check(matches(isDisplayed()))
}