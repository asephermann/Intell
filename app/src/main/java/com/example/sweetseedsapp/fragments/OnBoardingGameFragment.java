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
public class OnBoardingGameFragment extends Fragment {

    ImageView ob_games;

    public OnBoardingGameFragment() {
        // Required empty public constructor
    }

    public static OnBoardingGameFragment newInstance(){
        return new OnBoardingGameFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_on_boarding_game, container, false);
        ob_games = rootView.findViewById(R.id.ob_games_iv);

        return rootView;
    }

}
