package com.example.annastasyshena.findrepo

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.annastasyshena.findrepo.R.id.repoListView
import com.example.annastasyshena.findrepo.Screens.Search
import com.example.annastasyshena.findrepo.Screens.SearchResultScreen
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by annastasyshena on 3/22/18.
 */


@RunWith(AndroidJUnit4::class)
class Tests {
    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun repoSearch() {
        val repoSearch = Search()
        repoSearch.checkHintUserField("View User's Repos")
        val text = "egg"
        repoSearch.lookForRepo(text)
        repoSearch.clickSearchButton()
        repoSearch.wait(globalTimeout)
        Thread.sleep(2000)
        val searchResult = SearchResultScreen()
        searchResult.clickListItem(repoListView, 0)
        val textFromUrl = searchResult.getTextFromUrl()
        Assert.assertTrue("URL does not contain your search word $text", textFromUrl.contains(text))

    }

    @Test
    fun userSearch() {
        val userSearch = Search()
        val userName = "anna"
        userSearch.lookForUser(userName)
        userSearch.clickUserButton()
        Thread.sleep(2000)
        val searchResult = SearchResultScreen()
        searchResult.clickListItem(repoListView, 0)
        val textFromUrl = searchResult.getTextFromUrl()
        Assert.assertTrue("URL does not contain the user $userName you search for", textFromUrl.contains(userName))

    }

    @Test
    fun snackBarTest() {
        val search = Search()
        val userName = "Does not exist..."
        val expectedText = "User not found :( Go back and try again!"
        search.lookForUser(userName)
        search.clickUserButton()
        Thread.sleep(2000)
        search.wait(2000)
        val searchList = SearchResultScreen()
        searchList.snackbarAssertion(expectedText)
    }
}