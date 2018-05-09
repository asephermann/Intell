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
    StatsInnerRVData statsInnerRVData;

    public StatsFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(){
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
        initRecyclerView();
        return view;
    }

    private List<StatsOuterData> populateOutRVData(){
        List<StatsOuterData> dataForStats = new ArrayList<>();
        dataForStats.add(new StatsOuterData(R.id.badge_banner));
        dataForStats.add(new StatsOuterData(R.id.inner_rv));

        for(int i = 0; i < dataForStats.size(); i++){
            statsOuterData = dataForStats.get(i);
            statsOuterData.setStatsInnerRVDataList(getBadgeList());
            Log.d(TAG, "populateOutRVData: " + dataForStats.get(i));
        }
        return dataForStats;
    }

    private List<StatsInnerRVData> getBadgeList() {
        List<StatsInnerRVData> badges = new ArrayList<>();
        badges.add(new StatsInnerRVData(R.drawable.badge_banner, 1));
        badges.add(new StatsInnerRVData(R.drawable.badge_banner, 2));
        badges.add(new StatsInnerRVData(R.drawable.badge_banner, 3));
        badges.add(new StatsInnerRVData(R.drawable.badge_banner, 4));
        badges.add(new StatsInnerRVData(R.drawable.badge_banner, 5));
        badges.add(new StatsInnerRVData(R.drawable.badge_banner, 6));
        badges.add(new StatsInnerRVData(R.drawable.badge_banner, 7));
        Log.d(TAG, "getBadgeList: " + badges);
        return badges;
    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        statsRecyclerView.setLayoutManager(layoutManager);
        StatsOuterAdapter statsOuterAdapter = new StatsOuterAdapter(populateOutRVData());
        statsRecyclerView.setAdapter(statsOuterAdapter);
        statsOuterAdapter.notifyDataSetChanged();
    }
}
