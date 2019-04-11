package com.gauravk.bubblebarsample;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gauravk.bubblebarsample.adapters.ScreenSlidePagerAdapter;
import com.gauravk.bubblebarsample.fragment.ScreenSlidePageFragment;
import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.BubbleToggleView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

import java.util.ArrayList;

public class BottomBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);

        ArrayList<ScreenSlidePageFragment> fragList = new ArrayList<>();
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.home), R.color.red_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.search), R.color.blue_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.likes), R.color.blue_grey_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.notification), R.color.green_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.profile), R.color.purple_inactive));
        ScreenSlidePagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(fragList, getSupportFragmentManager());

        final BubbleNavigationLinearView bubbleNavigationLinearView = findViewById(R.id.bottom_navigation_view_linear);

        final BubbleToggleView bubbleToggleView1 = new BubbleToggleView(this);
        bubbleToggleView1.setId(ViewCompat.generateViewId());
        final BubbleToggleView bubbleToggleView2 = new BubbleToggleView(this);
        bubbleToggleView2.setId(ViewCompat.generateViewId());
        final BubbleToggleView bubbleToggleView3 = new BubbleToggleView(this);
        bubbleToggleView3.setId(ViewCompat.generateViewId());

        bubbleToggleView1.setBtDuration(300);
        bubbleToggleView1.setBtTitle("searchfdfdffd");
        bubbleToggleView1.setBtIcon(R.drawable.ic_happy);
        bubbleToggleView1.setBtColorActive(Color.parseColor("green"));
        bubbleToggleView1.setBtColorInactive(Color.parseColor("red"));
        bubbleToggleView2.setBtDuration(300);

        bubbleToggleView3.setBtDuration(300);
        bubbleToggleView3.setBtColorActive(Color.parseColor("grey"));
        bubbleToggleView3.setBtColorInactive(Color.parseColor("yellow"));


//        bubbleToggleView.setBtShape(R.drawable.transition_background_drawable_home);

        bubbleNavigationLinearView.addView(bubbleToggleView1);
        bubbleNavigationLinearView.addView(bubbleToggleView3);
//        bubbleNavigationLinearView.initialize();



//       bubbleToggleView.setB(android.R.drawable.ic_dialog_map);

//        bubbleNavigationLinearView.setTypeface(Typeface.createFromAsset(getAssets(), "rubik.ttf"));

//        bubbleNavigationLinearView.setBadgeValue(0, "40");
//        bubbleNavigationLinearView.setBadgeValue(1, null); //invisible badge
//        bubbleNavigationLinearView.setBadgeValue(2, "7");
//        bubbleNavigationLinearView.setBadgeValue(3, "2");
//        bubbleNavigationLinearView.setBadgeValue(4, ""); //empty badge

//        bubbleNavigationLinearView.setBackgroundColor(Color.parseColor("red"));
//        bubbleNavigationLinearView.setElevation();

        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                bubbleNavigationLinearView.setCurrentActiveItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        bubbleNavigationLinearView.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                viewPager.setCurrentItem(position, true);
            }
        });

    }
}
