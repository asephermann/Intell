package com.example.sweetseedsapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.controllersandviews.GridViewAdapter;
import com.example.sweetseedsapp.controllersandviews.StatsOuterAdapter;
import com.example.sweetseedsapp.models.StatsGridViewModel;
import com.example.sweetseedsapp.models.StatsInnerRVModel;
import com.example.sweetseedsapp.models.StatsOuterRVModel;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatsFragment extends Fragment {

    private static String TAG = "StatsFragment";
    GridView gridView;

    public StatsFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        StatsFragment statsFragment = new StatsFragment();
        return statsFragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats, container, false);
        gridView = view.findViewById(R.id.grid_view_badges);

        //For grid view adapter
        gridView.setAdapter(new GridViewAdapter(getContext()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //Set up dialog box for the badge to explain what they are for.
            }
        });

        return view;
    }


}

