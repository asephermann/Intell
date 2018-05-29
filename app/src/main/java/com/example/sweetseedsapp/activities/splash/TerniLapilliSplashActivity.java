package com.example.sweetseedsapp.activities.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.activities.TerniLapilliActivity;

public class TerniLapilliSplashActivity extends AppCompatActivity {

    ImageView terni_Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terni_lapilli_splash);

        terni_Logo = findViewById(R.id.terni_logo);

        final Intent intent = new Intent(this, TerniLapilliActivity.class);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
