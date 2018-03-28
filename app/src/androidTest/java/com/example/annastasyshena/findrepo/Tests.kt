package com.example.annastasyshena.findrepo

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.annastasyshena.findrepo.R.id.repoListView
import com.example.annastasyshena.findrepo.Screens.Search
import com.example.annastasyshena.findrepo.Screens.SearchResultScreen
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
        val text = "repo"
        repoSearch.lookForRepo(text)
        repoSearch.clickSearchButton()
        repoSearch.wait(globalTimeout)
        val searchResult = SearchResultScreen()
        searchResult.clickListItem(repoListView, 0)

    }

    @Test
    fun userSearch() {
        val userSearch = Search()
        val userName = "Anna"
        userSearch.lookForUser(userName)
        userSearch.clickUserButton()
        userSearch.wait(globalTimeout)
        val searchResult = SearchResultScreen()
    }

    @Test
    fun snackBarTest() {
        val search = Search()
        val userName = "Does not exist..."
        val expectedText = "User not found :( Go back and try again!"
        search.lookForUser(userName)
        search.clickUserButton()
        val searchList = SearchResultScreen()
        searchList.wait(1000)
        searchList.snackbarAssertion(expectedText)
    }



}