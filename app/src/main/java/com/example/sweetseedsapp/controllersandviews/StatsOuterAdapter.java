package com.example.sweetseedsapp.controllersandviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.models.StatsOuterData;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 4/24/18.
 */

public class StatsOuterAdapter extends RecyclerView.Adapter<StatsOuterAdapter.StatsOuterViewHolder> {

    private static String TAG = "StatsOuterAdapter";
    private List<StatsOuterData> dataForStats;

    public StatsOuterAdapter(List<StatsOuterData> statsOuterDataList) {
        this.dataForStats = statsOuterDataList;
    }

    @NonNull
    @Override
    public StatsOuterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stats_outer_itemview, parent, false);
        return new StatsOuterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsOuterAdapter.StatsOuterViewHolder holder, int position) {
        StatsOuterViewHolder statsOuterViewHolder = holder;
        statsOuterViewHolder.bind(dataForStats.get(position));
        Log.d(TAG, "onBindViewHolder: " + dataForStats.size());
    }


    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + dataForStats);
        return dataForStats == null ? 0 : dataForStats.size();

    }

    public class StatsOuterViewHolder extends RecyclerView.ViewHolder {

        ImageView badgeBanner;
        RecyclerView innerRecyclerView;


        public StatsOuterViewHolder(View itemView) {
            super(itemView);
            badgeBanner = itemView.findViewById(R.id.badge_banner);
            innerRecyclerView = itemView.findViewById(R.id.inner_rv);
        }

        public void bind(StatsOuterData statsOuterData) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
            innerRecyclerView.setLayoutManager(layoutManager);
            innerRecyclerView.setAdapter(new StatsOuterAdapter(statsOuterData.getStatsOuterDataList()));

        }
    }
}
