package com.example.sweetseedsapp.activities;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sweetseedsapp.controllersandviews.BirdWatchingNaturalistGameVIew;

public class BirdWatchingNaturalistGameActivity extends AppCompatActivity {
     private BirdWatchingNaturalistGameVIew mBirdWatchingNaturalistGameActivity;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

            mBirdWatchingNaturalistGameActivity = new BirdWatchingNaturalistGameVIew(this);
            mBirdWatchingNaturalistGameActivity.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
            setContentView(mBirdWatchingNaturalistGameActivity);
        }

        @Override
        protected void onPause() {
            super.onPause();

            mBirdWatchingNaturalistGameActivity.pause();
        }

        @Override
        protected void onPostResume() {
            super.onPostResume();

            mBirdWatchingNaturalistGameActivity.resume();
        }
    }
