package com.example.sweetseedsapp.controllersandviews;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.sweetseedsapp.R;

/**
 * Created by vivianbabiryekulumba on 5/20/18.
 */

public class GamesGridViewAdapter extends BaseAdapter {

    public GamesGridViewAdapter() {

    }

    @Override
    public int getCount() {
        return 9;
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder")
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_grid_item_view, parent, false);
        return view;
    }

}
