package com.example.sweetseedsapp.controllersandviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.models.StatsOuterData;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 4/24/18.
 */

public class StatsOuterAdapter extends RecyclerView.Adapter<StatsOuterAdapter.StatsOuterViewHolder> {

    private List<StatsOuterData> statsDataList;

    public StatsOuterAdapter(List<StatsOuterData> dataForStats) {
        this.statsDataList = dataForStats;
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
        statsOuterViewHolder.bind(statsDataList.get(position));
    }


    @Override
    public int getItemCount() {
        return statsDataList.size();
    }

    public class StatsOuterViewHolder extends RecyclerView.ViewHolder {

        RecyclerView innerRecyclerView;

        public StatsOuterViewHolder(View itemView) {
            super(itemView);
            innerRecyclerView = itemView.findViewById(R.id.inner_rv);
        }

        public void bind(StatsOuterData statsOuterData) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
            innerRecyclerView.setLayoutManager(layoutManager);
            innerRecyclerView.setAdapter(new StatsInnerAdapter(statsOuterData.getColorList()));

        }
    }
}
