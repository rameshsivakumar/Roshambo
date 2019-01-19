package com.app.roshambo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    /**
     * Use {@link ActivityScenarioRule} to create and launch the activity under test, and close it
     * after test completes. This is a replacement for {@link androidx.test.rule.ActivityTestRule}.
     */
    @Rule public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void chooseRock_checkOutput() {
        onView(withId(R.id.btn_rock))
                .perform(click());

        // Check that user selected and phone selected images are displayed.
        onView(withId(R.id.iv_input)).check(matches(isDisplayed()));
        onView(withId(R.id.iv_output)).check(matches(isDisplayed()));

        //Following line can be used for testing Toast message if displayed or not
        //In our case, since the toast message varies randomly, we cannot check for specific toast message.
        //onView(withText(R.string.toast)).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void choosePaper_checkOutput() {
        onView(withId(R.id.btn_paper))
                .perform(click());

        // Check that user selected and phone selected images are displayed.
        onView(withId(R.id.iv_input)).check(matches(isDisplayed()));
        onView(withId(R.id.iv_output)).check(matches(isDisplayed()));
    }

    @Test
    public void chooseScissor_checkOutput() {
        onView(withId(R.id.btn_scissors))
                .perform(click());

        // Check that user selected and phone selected images are displayed.
        onView(withId(R.id.iv_input)).check(matches(isDisplayed()));
        onView(withId(R.id.iv_output)).check(matches(isDisplayed()));
    }
}
