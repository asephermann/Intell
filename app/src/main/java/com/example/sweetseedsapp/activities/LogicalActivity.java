package com.example.sweetseedsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.controllersandviews.GamesAdapter;
import com.example.sweetseedsapp.controllersandviews.GamesGridViewAdapter;

public class LogicalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logical);

        GridView mGridView = findViewById(R.id.logical_tx);
        mGridView.setAdapter(new GamesGridViewAdapter());


    }


}
