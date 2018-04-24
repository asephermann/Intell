package com.example.sweetseedsapp.controllersandviews;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sweetseedsapp.R;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 4/24/18.
 */

public class StatsInnerAdapter extends RecyclerView.Adapter<StatsInnerAdapter.StatsInnerViewHolder> {

    private List<String> colorList;

    public StatsInnerAdapter(List<String> colorList) {
        this.colorList = colorList;
    }


    @NonNull
    @Override
    public StatsInnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StatsInnerViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsInnerAdapter.StatsInnerViewHolder holder, int position) {
        holder.onBind(colorList.get(position), position);
    }


    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public class StatsInnerViewHolder extends RecyclerView.ViewHolder {


        public StatsInnerViewHolder(ViewGroup itemView) {
            super(inflateLayout(itemView));
        }

        public void onBind(String color, int position){
            itemView.setBackgroundColor(Color.parseColor(color));
            TextView textView = itemView.findViewById(R.id.rv_tv);
            textView.setText(String.valueOf(position));
        }
    }

    private static View inflateLayout(ViewGroup itemView) {
        return LayoutInflater.from(itemView.getContext()).inflate(R.layout.stats_inner_itemview, itemView, false);
    }
}
