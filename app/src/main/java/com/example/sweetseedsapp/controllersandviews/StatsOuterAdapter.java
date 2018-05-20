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
import com.example.sweetseedsapp.models.StatsOuterRVModel;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by vivianbabiryekulumba on 4/24/18.
 */

public class StatsOuterAdapter extends RecyclerView.Adapter<StatsOuterAdapter.StatsOuterViewHolder> {

    private List<StatsOuterRVModel> dataForStats;
    private RecyclerView innerRecyclerView;
    private RecyclerView gridRecyclerView;
    private ImageView badge_status;


    public StatsOuterAdapter(List<StatsOuterRVModel> statsOuterDataList) {
        this.dataForStats = statsOuterDataList;
    }

    @NonNull
    @Override
    public StatsOuterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stats_outer_itemview, parent, false);
        badge_status = view.findViewById(R.id.badge_status_banner);
        innerRecyclerView = view.findViewById(R.id.inner_rv);
        gridRecyclerView = view.findViewById(R.id.grid_view_badges);
        return new StatsOuterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsOuterAdapter.StatsOuterViewHolder holder, int position) {
        holder.bind(dataForStats.get(position));
        Log.d(TAG, "onBindViewHolder: " + dataForStats.size());
    }

    @Override
    public int getItemCount() {
        return dataForStats.size();
    }

    class StatsOuterViewHolder extends RecyclerView.ViewHolder {

        StatsOuterViewHolder(View itemView) {
            super(itemView);
        }

        void bind(StatsOuterRVModel statsOuterData) {
            //For the outer data in the stats frag.
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
            innerRecyclerView.setLayoutManager(layoutManager);
            innerRecyclerView.setAdapter(new StatsInnerAdapter(statsOuterData.getStatsInnerRVDataList()));

            //For the grid recycler view
            GridLayoutManager gridLayoutManager = new GridLayoutManager(itemView.getContext(), 3);
            gridRecyclerView.setLayoutManager(gridLayoutManager);
            gridRecyclerView.setAdapter(new GridViewAdapter(statsOuterData.getGridViewData()));
            gridRecyclerView.setHasFixedSize(false);
        }
    }
}
