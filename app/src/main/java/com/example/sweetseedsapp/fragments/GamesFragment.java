package com.example.sweetseedsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.controllersandviews.GamesAdapter;
import com.example.sweetseedsapp.models.GamesModel;
import com.example.sweetseedsapp.models.StatsOuterRVModel;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class GamesFragment extends Fragment {

    GamesModel gamesModel;
    RecyclerView recyclerView;
    private List<GamesModel> dataForGames = new ArrayList<>();

    public GamesFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(){
        return new GamesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_games, container, false);
        recyclerView = view.findViewById(R.id.games_rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        GamesAdapter gamesAdapter = new GamesAdapter(populateGamesFragment());
        gamesAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(gamesAdapter);
        return view;
    }

    private List<GamesModel> populateGamesFragment() {
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
            Log.d(TAG, "populateOutRVData: " + dataForGames.get(i));
        }
        return dataForGames;
    }

}
