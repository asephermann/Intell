package com.example.sweetseedsapp.activities.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.activities.GamesActivity;
import com.example.sweetseedsapp.activities.OnBoardingActivity;
import com.example.sweetseedsapp.fragments.GamesFragment;

public class SplashActivity extends AppCompatActivity {

    ImageView appLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        appLogo = findViewById(R.id.app_logo);

        final Intent intent = new Intent(this, GamesActivity.class);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
