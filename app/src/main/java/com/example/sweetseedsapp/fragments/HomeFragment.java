package com.example.sweetseedsapp.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sweetseedsapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    CardView cardView;
    ImageView home_coming;
    TextView home_tv;
    TextView home_tv2;
    TextView home_tv3;
    TextView home_tv4;
    Typeface typeface;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        cardView = view.findViewById(R.id.home_card_view);
        home_coming = view.findViewById(R.id.home_card_iv);
        home_tv = view.findViewById(R.id.home_card_tv1);
        home_tv2 = view.findViewById(R.id.home_card_tv2);
        home_tv3 = view.findViewById(R.id.home_card_tv3);
        home_tv4 = view.findViewById(R.id.home_card_tv4);
        home_tv.setText(R.string.home_stat1);
        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/edo.ttf");
        home_tv.setTypeface(typeface);
        home_tv2.setText(R.string.home_stat2);
        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/edo.ttf");
        home_tv2.setTypeface(typeface);
        home_tv3.setText(R.string.home_stat3);
        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/edo.ttf");
        home_tv3.setTypeface(typeface);
        home_tv4.setText(R.string.home_stat4);
        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/edo.ttf");
        home_tv4.setTypeface(typeface);
        return view;
    }

}
