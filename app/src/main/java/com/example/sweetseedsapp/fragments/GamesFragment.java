package com.example.sweetseedsapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.activities.ninetypes.BodilyKinActivity;
import com.example.sweetseedsapp.activities.ninetypes.ExistentialActivity;
import com.example.sweetseedsapp.activities.ninetypes.InterpersonalActivity;
import com.example.sweetseedsapp.activities.ninetypes.IntrapersonalActivity;
import com.example.sweetseedsapp.activities.ninetypes.LinguisticActivity;
import com.example.sweetseedsapp.activities.ninetypes.LogicalActivity;
import com.example.sweetseedsapp.activities.ninetypes.MusicalActivity;
import com.example.sweetseedsapp.activities.ninetypes.NaturalistActivity;
import com.example.sweetseedsapp.activities.ninetypes.SpatialActivity;
import com.example.sweetseedsapp.controllersandviews.GamesAdapter;
import com.example.sweetseedsapp.models.GamesModel;

import java.util.ArrayList;
import java.util.List;


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

    public static Fragment newInstance() {
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

        switch (gamesAdapter.getItemCount()){
            case 0:
                Intent intent = new Intent(getActivity(), BodilyKinActivity.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(getActivity(), SpatialActivity.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(getActivity(), LogicalActivity.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(getActivity(), NaturalistActivity.class);
                startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(getActivity(), MusicalActivity.class);
                startActivity(intent4);
                break;
            case 5:
                Intent intent5 = new Intent(getActivity(), InterpersonalActivity.class);
                startActivity(intent5);
                break;
            case 6:
                Intent intent6 = new Intent(getActivity(), IntrapersonalActivity.class);
                startActivity(intent6);
                break;
            case 7:
                Intent intent7 = new Intent(getActivity(), LinguisticActivity.class);
                startActivity(intent7);
                break;
            case 8:
                Intent intent8 = new Intent(getActivity(), ExistentialActivity.class);
                startActivity(intent8);
        }
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
        }
        return dataForGames;
    }
}
