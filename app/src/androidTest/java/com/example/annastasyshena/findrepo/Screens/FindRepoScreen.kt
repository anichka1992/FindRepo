package com.example.annastasyshena.findrepo.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.annastasyshena.findrepo.R


/**
 * Created by annastasyshena on 3/22/18.
 */


open class FindRepoScreen : BaseScreen() {

    fun typeText(id: Int, text: String): ViewInteraction = onView(withId(id)).perform(typeText(text))

    fun clickButton(id: Int): ViewInteraction = onView((withId(id))).perform(ViewActions.click())

    fun checkHint(id: Int, hintText: String): ViewInteraction = onView(withId(id)).check(matches(withHint(hintText)))

}

class Search : FindRepoScreen() {

    fun checkHintUserField(text: String) = apply { checkHint(R.id.userRepoEditText, text) }

    fun lookForRepo(text: String) = apply { typeText(R.id.SearchEditText, text) }

    fun clickSearchButton() = apply { clickButton(R.id.searchButton) }

    fun lookForUser(text: String) = apply { typeText(R.id.userRepoEditText, text) }

    fun clickUserButton() = apply { clickButton(R.id.userRepoButton) }

    fun wait(milliseconds: Long): ViewInteraction = Espresso.onView(isRoot()).perform(waitFor(milliseconds))
}