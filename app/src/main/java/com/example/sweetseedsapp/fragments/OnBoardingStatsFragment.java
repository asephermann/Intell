package com.example.sweetseedsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sweetseedsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnBoardingStatsFragment extends Fragment {

    ImageView ob_stats;

    public OnBoardingStatsFragment() {
        // Required empty public constructor
    }

    public static OnBoardingStatsFragment newInstance(){
        return new OnBoardingStatsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_on_boarding_stats, container, false);
        ob_stats = rootView.findViewById(R.id.ob_stats_iv);

        return rootView;
    }

}
