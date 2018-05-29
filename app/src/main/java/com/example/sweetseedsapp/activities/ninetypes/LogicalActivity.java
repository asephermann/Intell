package com.example.sweetseedsapp.activities.ninetypes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.activities.splash.TerniLapilliSplashActivity;
import com.example.sweetseedsapp.controllersandviews.LogicalAdapter;
import com.example.sweetseedsapp.models.LogicalModel;
import java.util.ArrayList;
import java.util.List;

public class LogicalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<LogicalModel> logicalModelList = new ArrayList<>();
    LogicalModel logicalModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logical);

        recyclerView = findViewById(R.id.logical_menu_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        LogicalAdapter logicalAdapter = new LogicalAdapter(populateLogicalGames());
        logicalAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(logicalAdapter);
    }

    private List<LogicalModel> populateLogicalGames() {
        logicalModelList.add(new LogicalModel(R.drawable.terni_lapilli));
        logicalModelList.add(new LogicalModel(R.drawable.terni_lapilli));
        logicalModelList.add(new LogicalModel(R.drawable.terni_lapilli));
        logicalModelList.add(new LogicalModel(R.drawable.terni_lapilli));
        logicalModelList.add(new LogicalModel(R.drawable.terni_lapilli));
        logicalModelList.add(new LogicalModel(R.drawable.terni_lapilli));
        logicalModelList.add(new LogicalModel(R.drawable.terni_lapilli));

        for (int i = 0; i < logicalModelList.size(); i++) {
            logicalModel = logicalModelList.get(i);
        }

        return logicalModelList;
    }

}
