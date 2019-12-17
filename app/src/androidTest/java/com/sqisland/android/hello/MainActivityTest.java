package com.sqisland.android.hello;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
  @Rule
  public ActivityTestRule<MainActivity> activityTestRule
      = new ActivityTestRule<>(MainActivity.class);

  @Test
  public void testBye() {
    onView(withId(R.id.greeting))
        .check(matches(withText(R.string.hello_world)));

    openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
    onView(withText(R.string.say_bye))
        .perform(click());

    onView(withId(R.id.greeting))
        .check(matches(withText(R.string.bye)));
  }
}