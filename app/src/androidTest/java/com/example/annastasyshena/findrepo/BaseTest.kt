package com.example.annastasyshena.findrepo

import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import android.view.View
import android.support.test.espresso.util.HumanReadables
import android.support.test.espresso.PerformException
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.espresso.util.TreeIterables
import java.util.concurrent.TimeoutException
import android.support.test.espresso.matcher.ViewMatchers.isRoot
import org.hamcrest.Matcher
import android.support.test.espresso.matcher.ViewMatchers.isRoot
import android.support.test.espresso.matcher.ViewMatchers.isRoot
import android.support.test.espresso.matcher.ViewMatchers.isRoot








/**
 * Created by annastasyshena on 3/23/18.
 */
open class BaseTest {

    fun waitFor(millis: Long): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isRoot()
            }

            override fun getDescription(): String {
                return "Wait for $millis milliseconds."
            }

            override fun perform(uiController: UiController, view: View) {
                uiController.loopMainThreadForAtLeast(millis)
            }
        }
    }
}
