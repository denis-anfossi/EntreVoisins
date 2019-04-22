package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.openclassrooms.entrevoisins.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NeighbourDetailsActivityTest {

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule = new ActivityTestRule<>(ListNeighbourActivity.class);

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void neighbourDetailsActivity_isDisplayed() {
        onView(allOf(withId(R.id.list_neighbours),
                withParent(allOf(withId(R.id.container), childAtPosition(withId(R.id.main_content), 1))),
                isDisplayed()))
                .perform(actionOnItemAtPosition(6, click()));

        onView(withId(R.id.activity_neighbours_details)).check(matches(isDisplayed()));
    }

    @Test
    public void neighbourDetailsActivity_nameIsDisplayed() {
        onView(allOf(withId(R.id.list_neighbours),
                withParent(allOf(withId(R.id.container), childAtPosition(withId(R.id.main_content), 1))),
                isDisplayed()))
                .perform(actionOnItemAtPosition(6, click()));

        onView(withId(R.id.activity_neighbours_details)).check(matches(isDisplayed()));
        onView(withId(R.id.activity_neighbour_details_toolbar_txt)).check(matches(withText("Laetitia")));
        onView(withId(R.id.infos_card_title_txt)).check(matches(withText("Laetitia")));
    }
}
