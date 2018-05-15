package com.example.sweetseedsapp.controllersandviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.models.GamesModel;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 5/14/18.
 */

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {

    List<GamesModel> gamesModel;

    public GamesAdapter(List<GamesModel> gamesModelList) {
        this.gamesModel = gamesModelList;
    }

    @NonNull
    @Override
    public GamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_item_view, parent, false);
        return new GamesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GamesViewHolder holder, int position) {
        holder.onBind(gamesModel.get(position));
    }

    @Override
    public int getItemCount() {
        return gamesModel.size();
    }

    class GamesViewHolder extends RecyclerView.ViewHolder {

        GamesViewHolder(View itemView) {
            super(itemView);
        }

        void onBind(GamesModel gamesModel) {
            ImageView imageView = itemView.findViewById(R.id.games_shuffler_iv);
            imageView.setImageResource(gamesModel.getImage());
        }
    }
}
