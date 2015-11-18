package com.sqisland.android.hello;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
  public MainActivityTest() {
    super(MainActivity.class) ;
  }

  public void testBye() {
    getActivity();

    onView(withId(R.id.greeting))
        .check(matches(withText(R.string.hello_world)));

    openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
    onView(withText(R.string.say_bye))
        .perform(click());

    onView(withId(R.id.greeting))
        .check(matches(withText(R.string.bye)));
  }
}