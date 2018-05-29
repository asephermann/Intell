package com.example.sweetseedsapp.controllersandviews;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.activities.splash.TerniLapilliSplashActivity;
import com.example.sweetseedsapp.models.LogicalModel;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 5/28/18.
 */

public class LogicalAdapter extends RecyclerView.Adapter<LogicalAdapter.LogicalViewHolder> {

    List<LogicalModel> logicalModel;
    ClickListener clickListener;

    public LogicalAdapter(Context applicationContext, List<LogicalModel> logicalModelList, ClickListener clickListener) {
        this.logicalModel = logicalModelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public LogicalAdapter.LogicalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.logical_item_view, parent, false);
        final LogicalViewHolder logicalViewHolder = new LogicalViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(v, logicalViewHolder.getAdapterPosition());
            }
        });
        return new LogicalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogicalAdapter.LogicalViewHolder holder, int position) {
        holder.onBind(logicalModel.get(position));
    }

    @Override
    public int getItemCount() {
        return logicalModel.size();
    }

    public class LogicalViewHolder extends RecyclerView.ViewHolder{

        ImageView logical_game_iv;

        public LogicalViewHolder(View itemView) {
            super(itemView);
        }

        public void onBind(LogicalModel logicalModel) {
            logical_game_iv = itemView.findViewById(R.id.logical_game_iv);
            logical_game_iv.setImageResource(logicalModel.getImage());
        }
    }
}
