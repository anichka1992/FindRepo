package com.example.annastasyshena.findrepo.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.annastasyshena.findrepo.R

/**
 * Created by annastasyshena on 3/22/18.
 */


open class FindRepoScreen : BaseScreen() {

    fun typeText(id: Int, text: String): ViewInteraction = onView(withId(id)).perform(typeText(text))

    fun clickButton(id: Int): ViewInteraction = onView((withId(id))).perform(click())

    fun checkHint(id: Int, hintText: String): ViewInteraction = onView(withId(id)).check(matches(withHint(hintText)))

}

class Search : FindRepoScreen() {

    fun checkHintUserField(text: String) =  checkHint(R.id.userRepoEditText, text)

    fun lookForRepo(text: String) = typeText(R.id.SearchEditText, text)

    fun clickSearchButton() = clickButton(R.id.searchButton)

    fun lookForUser(text: String) = typeText(R.id.userRepoEditText, text)

    fun clickUserButton() = clickButton(R.id.userRepoButton)

    fun wait(milliseconds: Long): ViewInteraction = Espresso.onView(isRoot()).perform(waitFor(milliseconds))
}