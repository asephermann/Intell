package com.example.sweetseedsapp.controllersandviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.models.StatsGridViewData;
import com.example.sweetseedsapp.models.StatsOuterData;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by vivianbabiryekulumba on 4/24/18.
 */

public class StatsOuterAdapter extends RecyclerView.Adapter<StatsOuterAdapter.StatsOuterViewHolder> {

    private List<StatsOuterData> dataForStats;

    public StatsOuterAdapter(List<StatsOuterData> dataForStats) {
        this.dataForStats = dataForStats;
    }

    @NonNull
    @Override
    public StatsOuterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stats_outer_itemview, parent, false);
        Log.d(TAG, "onCreateViewHolder: " + view);
        return new StatsOuterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsOuterAdapter.StatsOuterViewHolder holder, int position) {
        holder.bind(dataForStats.get(position));
        String TAG = "StatsOuterAdapter";
        Log.d(TAG, "onBindViewHolder: " + dataForStats.size());
    }


    @Override
    public int getItemCount() {
        return dataForStats.size();
    }

    class StatsOuterViewHolder extends RecyclerView.ViewHolder {

        ImageView badgeBanner;
        RecyclerView innerRecyclerView;
        RecyclerView gridRecyclerView;


        StatsOuterViewHolder(View itemView) {
            super(itemView);
            badgeBanner = itemView.findViewById(R.id.badge_status_banner);
            innerRecyclerView = itemView.findViewById(R.id.inner_rv);
            gridRecyclerView = itemView.findViewById(R.id.grid_view_badges);
        }

        void bind(StatsOuterData statsOuterData) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
            innerRecyclerView.setLayoutManager(layoutManager);
            innerRecyclerView.setAdapter(new StatsInnerAdapter(statsOuterData.getStatsInnerRVDataList()));

            GridLayoutManager gridLayoutManager = new GridLayoutManager(itemView.getContext(), 3);
            gridRecyclerView.setLayoutManager(gridLayoutManager);
            gridRecyclerView.setAdapter(new GridViewAdapter(statsOuterData.getGridViewData()));
            gridRecyclerView.setHasFixedSize(false);

        }
    }
}
