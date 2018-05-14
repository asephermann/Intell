package com.example.sweetseedsapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.controllersandviews.StatsOuterAdapter;
import com.example.sweetseedsapp.models.StatsGridViewData;
import com.example.sweetseedsapp.models.StatsInnerRVData;
import com.example.sweetseedsapp.models.StatsOuterData;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatsFragment extends Fragment {

    private static String TAG = "StatsFragment";
    RecyclerView statsRecyclerView;
    StatsOuterData statsOuterData;
    List<StatsOuterData> dataForStats = new ArrayList<>();
    List<StatsGridViewData> gridViewData = new ArrayList<>();

    public StatsFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        StatsFragment statsFragment = new StatsFragment();
        return statsFragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats, container, false);
        statsRecyclerView = view.findViewById(R.id.stats_rv);

        populateOutRVData();
        getBadgeList();
        initRecyclerViews();
        populateGridView();
        return view;
    }

    private void populateGridView() {

        for(int i = 0; i < dataForStats.size(); i ++){
            statsOuterData = dataForStats.get(i);
            statsOuterData.setGridViewData(getGridViewData());
            Log.d(TAG, "populateGridView: " + gridViewData.size());
        }
    }

    private List<StatsGridViewData> getGridViewData(){
        gridViewData.add(new StatsGridViewData(R.drawable.badge_one, 0));
        gridViewData.add(new StatsGridViewData(R.drawable.badge_two, 1));
        gridViewData.add(new StatsGridViewData(R.drawable.badge_three, 2));
        gridViewData.add(new StatsGridViewData(R.drawable.badge_four, 3));
        gridViewData.add(new StatsGridViewData(R.drawable.badge_five, 4));
        gridViewData.add(new StatsGridViewData(R.drawable.badge_six, 5));
        gridViewData.add(new StatsGridViewData(R.drawable.badge_seven, 6));
        return gridViewData;
    }


    private List<StatsOuterData> populateOutRVData() {
        dataForStats.add(new StatsOuterData(R.id.badge_status_banner));
        dataForStats.add(new StatsOuterData(R.id.inner_rv));

        for (int i = 0; i < dataForStats.size(); i++) {
            statsOuterData = dataForStats.get(i);
            statsOuterData.setStatsInnerRVDataList(getBadgeList());
            Log.d(TAG, "populateOutRVData: " + dataForStats.get(i));
        }
        return dataForStats;
    }


    private List<StatsInnerRVData> getBadgeList() {
        List<StatsInnerRVData> badges = new ArrayList<>();
        badges.add(new StatsInnerRVData(R.drawable.badge_one, 1));
        badges.add(new StatsInnerRVData(R.drawable.badge_two, 2));
//        badges.add(new StatsInnerRVData(R.drawable.badge_three, 3));
//        badges.add(new StatsInnerRVData(R.drawable.badge_four, 4));
//        badges.add(new StatsInnerRVData(R.drawable.badge_five, 5));
//        badges.add(new StatsInnerRVData(R.drawable.badge_six, 6));
//        badges.add(new StatsInnerRVData(R.drawable.badge_seven, 7));
//        Log.d(TAG, "getBadgeList: " + badges);
        return badges;
    }

    private void initRecyclerViews() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        statsRecyclerView.setLayoutManager(layoutManager);
        StatsOuterAdapter statsOuterAdapter = new StatsOuterAdapter(populateOutRVData());
        statsRecyclerView.setAdapter(statsOuterAdapter);
        statsOuterAdapter.notifyDataSetChanged();
    }


}
