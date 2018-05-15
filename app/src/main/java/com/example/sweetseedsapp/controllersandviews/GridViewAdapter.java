package com.example.sweetseedsapp.controllersandviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.models.StatsGridViewModel;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 5/13/18.
 */

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.GridViewHolder> {

    private List<StatsGridViewModel> gridViewData;

    GridViewAdapter(List<StatsGridViewModel> gridViewData) {
        this.gridViewData = gridViewData;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridview_item_view, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        holder.onBind(gridViewData.get(position));
    }

    @Override
    public int getItemCount() {
        return gridViewData.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        ImageView badge;

        GridViewHolder(View itemView) {
            super(itemView);
            badge = itemView.findViewById(R.id.grid_view_iv);
        }

        void onBind(StatsGridViewModel statsGridViewData) {
            badge.setImageResource(statsGridViewData.getBadge());
        }
    }
}
