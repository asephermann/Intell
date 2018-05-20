package com.example.sweetseedsapp.controllersandviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.models.StatsInnerRVModel;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 4/24/18.
 */

public class StatsInnerAdapter extends RecyclerView.Adapter<StatsInnerAdapter.StatsInnerViewHolder> {

    private List<StatsInnerRVModel> statsInnerData;

    public StatsInnerAdapter(List<StatsInnerRVModel> statsInnerDataList) {
        this.statsInnerData = statsInnerDataList;
    }

    @NonNull
    @Override
    public StatsInnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StatsInnerViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsInnerAdapter.StatsInnerViewHolder holder, int position) {
        holder.onBind(statsInnerData.get(position));
    }


    @Override
    public int getItemCount() {
        return statsInnerData.size();
    }

    public class StatsInnerViewHolder extends RecyclerView.ViewHolder {

        public StatsInnerViewHolder(ViewGroup itemView) {
            super(inflateLayout(itemView));
        }

        public void onBind(StatsInnerRVModel statsInnerRVData){
            ImageView badge = itemView.findViewById(R.id.badge);
            badge.setImageResource(statsInnerRVData.getBadge());
        }
    }

    private static View inflateLayout(ViewGroup itemView) {
        return LayoutInflater.from(itemView.getContext()).inflate(R.layout.stats_inner_itemview, itemView, false);
    }
}
