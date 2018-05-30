package com.example.sweetseedsapp.activities;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.fragments.OnBoardingGameFragment;
import com.example.sweetseedsapp.fragments.OnBoardingHomeFragment;
import com.example.sweetseedsapp.fragments.OnBoardingReadySetGoFragment;
import com.example.sweetseedsapp.fragments.OnBoardingStatsFragment;
import com.example.sweetseedsapp.fragments.OnBoardingWelcomeFragment;
import com.tmall.ultraviewpager.UltraViewPager;


public class OnBoardingActivity extends FragmentActivity {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
//    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
//    private PagerAdapter mPagerAdapter;

    /**
     *
     * VideoView implementation
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        // Instantiate a ViewPager and a PagerAdapter.
//        mPager = findViewById(R.id.pager);
//        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
//        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
//        mPager.setAdapter(mPagerAdapter);

        UltraViewPager ultraViewPager = findViewById(R.id.pager);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
//initialize UltraPagerAdapter，and add child view to UltraViewPager
        PagerAdapter adapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        ultraViewPager.setAdapter(adapter);

//initialize built-in indicator
        ultraViewPager.initIndicator();
//set style of indicators
        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(Color.GREEN)
                .setNormalColor(Color.WHITE)
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));
//set the alignment
        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
//construct built-in indicator, and add it to  UltraViewPager
        ultraViewPager.getIndicator().build();

//set an infinite loop to false
        ultraViewPager.setInfiniteLoop(false);
//enable auto-scroll mode
//        ultraViewPager.setAutoScroll(2000);

    }


//
//    @Override
//    public void onBackPressed() {
//        if (mPager.getCurrentItem() == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//            super.onBackPressed();
//        } else {
//            // Otherwise, select the previous step.
//            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
//        }
//    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return OnBoardingWelcomeFragment.newInstance();
                case 1:
                    return OnBoardingHomeFragment.newInstance();
                case 2:
                    return OnBoardingStatsFragment.newInstance();
                case 3:
                    return OnBoardingGameFragment.newInstance();
                case 4:
                    return OnBoardingReadySetGoFragment.newInstance();
                default:
                    return OnBoardingWelcomeFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    private class ZoomOutPageTransformer implements ViewPager.PageTransformer {

        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}
