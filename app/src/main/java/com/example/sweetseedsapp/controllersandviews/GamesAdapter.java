package com.example.sweetseedsapp.controllersandviews;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.activities.BodilyKinActivity;
import com.example.sweetseedsapp.activities.ExistentialActivity;
import com.example.sweetseedsapp.activities.GamesActivity;
import com.example.sweetseedsapp.activities.InterpersonalActivity;
import com.example.sweetseedsapp.activities.IntrapersonalActivity;
import com.example.sweetseedsapp.activities.LinguisticActivity;
import com.example.sweetseedsapp.activities.LogicalActivity;
import com.example.sweetseedsapp.activities.MusicalActivity;
import com.example.sweetseedsapp.activities.NaturalistActivity;
import com.example.sweetseedsapp.activities.SpatialActivity;
import com.example.sweetseedsapp.models.GamesModel;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 5/14/18.
 */

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {

    private List<GamesModel> gamesModel;

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

    @Override
    public int getItemViewType(final int position) {
        return R.layout.games_item_view;
    }

    class GamesViewHolder extends RecyclerView.ViewHolder {

        GamesViewHolder(View itemView) {
            super(itemView);
        }

        void onBind(final GamesModel gamesModel) {
            ImageView imageView = itemView.findViewById(R.id.games_shuffler_iv);
            imageView.setImageResource(gamesModel.getImage());

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (gamesModel.getImage()) {
                        case R.drawable.bodily_kin:
                            Intent intent = new Intent(itemView.getContext(), BodilyKinActivity.class);
                            itemView.getContext().startActivity(intent);
                            break;
                        case R.drawable.spatial:
                            Intent intent1 = new Intent(itemView.getContext(), SpatialActivity.class);
                            itemView.getContext().startActivity(intent1);
                            break;
                        case R.drawable.logical:
                            Intent intent2 = new Intent(itemView.getContext(), LogicalActivity.class);
                            itemView.getContext().startActivity(intent2);
                            break;
                        case R.drawable.naturalist:
                            Intent intent3 = new Intent(itemView.getContext(), NaturalistActivity.class);
                            itemView.getContext().startActivity(intent3);
                            break;
                        case R.drawable.musical:
                            Intent intent4 = new Intent(itemView.getContext(), MusicalActivity.class);
                            itemView.getContext().startActivity(intent4);
                            break;
                        case R.drawable.interpersonal:
                            Intent intent5 = new Intent(itemView.getContext(), InterpersonalActivity.class);
                            itemView.getContext().startActivity(intent5);
                            break;
                        case R.drawable.intrapersonal:
                            Intent intent6 = new Intent(itemView.getContext(), IntrapersonalActivity.class);
                            itemView.getContext().startActivity(intent6);
                            break;
                        case R.drawable.linguistic:
                            Intent intent7 = new Intent(itemView.getContext(), LinguisticActivity.class);
                            itemView.getContext().startActivity(intent7);
                            break;
                        case R.drawable.existential:
                            Intent intent8 = new Intent(itemView.getContext(), ExistentialActivity.class);
                            itemView.getContext().startActivity(intent8);
                    }
                }
            });
        }
    }
}
