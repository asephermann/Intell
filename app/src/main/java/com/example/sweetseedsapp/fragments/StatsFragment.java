package com.example.sweetseedsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.controllersandviews.StatsOuterAdapter;
import com.example.sweetseedsapp.models.StatsOuterData;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatsFragment extends Fragment {

    RecyclerView statsRecyclerView;


    public StatsFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(){
        StatsFragment statsFragment = new StatsFragment();
        return statsFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats, container, false);
        statsRecyclerView = view.findViewById(R.id.stats_rv);
        populateColorList();
        initRecyclerView();
        return view;
    }

    private List<StatsOuterData> populateColorList(){
        List<StatsOuterData> dataForStats = new ArrayList<>();
        dataForStats.add(new StatsOuterData("#ffffff"));
        dataForStats.add(new StatsOuterData("#f9982f"));
        dataForStats.add(new StatsOuterData("#e3ee31"));
        dataForStats.add(new StatsOuterData("#4366b0"));
        dataForStats.add(new StatsOuterData("#2f90f9"));
        dataForStats.add(new StatsOuterData("#bbbbbb"));
        dataForStats.add(new StatsOuterData("#aaaaaa"));

        for(int i = 0; i < dataForStats.size(); i++){
            StatsOuterData statsOuterData = dataForStats.get(i);
            statsOuterData.setColorList(getColorList());
        }
        return dataForStats;
    }

    private List<String> getColorList() {
        List<String> colors = new ArrayList<>();
        colors.add("#ffffff");
        colors.add("#f9982f");
        colors.add("#e3ee31");
        colors.add("#4366b0");
        colors.add("#2f90f9");
        colors.add("#bbbbbb");
        colors.add("#aaaaaa");
        return colors;
    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        statsRecyclerView.setLayoutManager(layoutManager);
        StatsOuterAdapter statsOuterAdapter = new StatsOuterAdapter(populateColorList());
        statsRecyclerView.setAdapter(statsOuterAdapter);
    }


}
