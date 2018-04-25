package com.example.sweetseedsapp.controllersandviews;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.models.StatsInnerRVData;
import com.example.sweetseedsapp.models.StatsOuterData;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 4/24/18.
 */

public class StatsInnerAdapter extends RecyclerView.Adapter<StatsInnerAdapter.StatsInnerViewHolder> {

    private List<StatsInnerRVData> statsInnerDataList;

    public StatsInnerAdapter(List<StatsInnerRVData> statsInnerDataList) {
        this.statsInnerDataList = statsInnerDataList;
    }

    @NonNull
    @Override
    public StatsInnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StatsInnerViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsInnerAdapter.StatsInnerViewHolder holder, int position) {
        holder.onBind(statsInnerDataList.get(position));
    }


    @Override
    public int getItemCount() {
        return statsInnerDataList.size();
    }

    public class StatsInnerViewHolder extends RecyclerView.ViewHolder {

        public StatsInnerViewHolder(ViewGroup itemView) {
            super(inflateLayout(itemView));
        }

        public void onBind(StatsInnerRVData statsInnerRVData){
            ImageView badgeBanner = itemView.findViewById(R.id.badge_banner);
            badgeBanner.setImageResource(R.drawable.badge_banner);

        }
    }

    private static View inflateLayout(ViewGroup itemView) {
        return LayoutInflater.from(itemView.getContext()).inflate(R.layout.stats_inner_itemview, itemView, false);
    }
}
