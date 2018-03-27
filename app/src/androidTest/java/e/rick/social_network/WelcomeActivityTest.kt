package e.rick.social_network

import android.app.Activity
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import e.rick.social_network.Presentation.HomeActivity.HomeActivity
import e.rick.social_network.R.id.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class WelcomeActivityTest {

    @Rule @JvmField
    val welcomeActivity = ActivityTestRule<WelcomeActivity>(WelcomeActivity::class.java)

    fun <T : Activity> nextOpenActivityIs(clazz: Class<T>) {
        intended(IntentMatchers.hasComponent(clazz.name))
    }

    @Test
    fun userLogin() {

        onView(withId(email)).perform(typeText("a@b.com")).perform(closeSoftKeyboard())
        onView(withId(password)).perform(typeText("123456")).perform(closeSoftKeyboard())
        onView(withId(login)).perform(click())
    }
}
