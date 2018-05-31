package com.example.sweetseedsapp.controllersandviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.models.StatsGridViewModel;
import com.example.sweetseedsapp.models.StatsOuterRVModel;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by vivianbabiryekulumba on 4/24/18.
 */

public class StatsOuterAdapter extends RecyclerView.Adapter<StatsOuterAdapter.StatsOuterViewHolder> {

    private List<StatsOuterRVModel> dataForStats;
    private GridView gridView;

    public StatsOuterAdapter(List<StatsOuterRVModel> statsOuterDataList) {
        this.dataForStats = statsOuterDataList;
    }

    @NonNull
    @Override
    public StatsOuterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stats_outer_itemview, parent, false);
        gridView = view.findViewById(R.id.grid_view_badges);
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


        public void bind(StatsOuterRVModel statsOuterRVModel) {

        }
    }
}
