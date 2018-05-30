package com.example.sweetseedsapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.activities.ninetypes.BodilyKinActivity;
import com.example.sweetseedsapp.activities.ninetypes.ExistentialActivity;
import com.example.sweetseedsapp.activities.ninetypes.InterpersonalActivity;
import com.example.sweetseedsapp.activities.ninetypes.IntrapersonalActivity;
import com.example.sweetseedsapp.activities.ninetypes.LinguisticActivity;
import com.example.sweetseedsapp.activities.ninetypes.LogicalActivity;
import com.example.sweetseedsapp.activities.ninetypes.MusicalActivity;
import com.example.sweetseedsapp.activities.ninetypes.NaturalistActivity;
import com.example.sweetseedsapp.activities.ninetypes.SpatialActivity;
import com.example.sweetseedsapp.controllersandviews.GamesAdapter;
import com.example.sweetseedsapp.models.GamesModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GamesFragment extends Fragment {

    private static CardView cardView1;
    private static CardView cardView2;
    private static CardView cardView3;
    private static CardView cardView4;
    private static CardView cardView5;
    private static CardView cardView6;
    private static CardView cardView7;
    private static CardView cardView8;
    private static CardView cardView9;

    public GamesFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new GamesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_games, container, false);

        //Set the cardViews
        cardView1 = view.findViewById(R.id.card_view1);
        cardView2 = view.findViewById(R.id.card_view2);
        cardView3 = view.findViewById(R.id.card_view3);
        cardView4 = view.findViewById(R.id.card_view4);
        cardView5 = view.findViewById(R.id.card_view5);
        cardView6 = view.findViewById(R.id.card_view6);
        cardView7 = view.findViewById(R.id.card_view7);
        cardView8 = view.findViewById(R.id.card_view8);
        cardView9 = view.findViewById(R.id.card_view9);

        //Set the onClickListeners to go to type activities.
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BodilyKinActivity.class);
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), LogicalActivity.class);
                startActivity(intent1);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), MusicalActivity.class);
                startActivity(intent2);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), NaturalistActivity.class);
                startActivity(intent3);
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getActivity(), SpatialActivity.class);
                startActivity(intent4);
            }
        });


        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getActivity(), IntrapersonalActivity.class);
                startActivity(intent5);
            }
        });


        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(getActivity(), InterpersonalActivity.class);
                startActivity(intent6);
            }
        });

        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(getActivity(), ExistentialActivity.class);
                startActivity(intent7);
            }
        });

        cardView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent(getActivity(), LinguisticActivity.class);
                startActivity(intent8);
            }
        });
        return view;
    }

}
