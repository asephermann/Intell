package com.example.sweetseedsapp.activities.ninetypes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.sweetseedsapp.R;

public class SpatialActivity extends AppCompatActivity {

    ImageView coming_soon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spatial);

        coming_soon = findViewById(R.id.coming_soon);
    }
}
