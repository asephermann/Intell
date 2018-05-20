package com.example.sweetseedsapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.controllersandviews.GamesAdapter;
import com.example.sweetseedsapp.models.GamesModel;

import java.util.ArrayList;
import java.util.List;

public class GamesActivity extends AppCompatActivity {

    GamesModel gamesModel;
    RecyclerView recyclerView;
    private List<GamesModel> dataForGames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        recyclerView = findViewById(R.id.games_rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplication(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        GamesAdapter gamesAdapter = new GamesAdapter(populateGamesActivity());
        gamesAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(gamesAdapter);

    }

    private List<GamesModel> populateGamesActivity() {
        dataForGames.add(new GamesModel(R.drawable.bodily_kin));
        dataForGames.add(new GamesModel(R.drawable.spatial));
        dataForGames.add(new GamesModel(R.drawable.logical));
        dataForGames.add(new GamesModel(R.drawable.naturalist));
        dataForGames.add(new GamesModel(R.drawable.musical));
        dataForGames.add(new GamesModel(R.drawable.interpersonal));
        dataForGames.add(new GamesModel(R.drawable.intrapersonal));
        dataForGames.add(new GamesModel(R.drawable.linguistic));
        dataForGames.add(new GamesModel(R.drawable.existential));

        for (int i = 0; i < dataForGames.size(); i++) {
            gamesModel = dataForGames.get(i);
        }
        return dataForGames;
    }
}
