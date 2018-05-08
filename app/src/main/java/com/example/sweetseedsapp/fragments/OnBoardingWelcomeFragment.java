package com.example.sweetseedsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sweetseedsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnBoardingWelcomeFragment extends Fragment {

    ImageView ob_welcome_iv;

    public OnBoardingWelcomeFragment() {
        // Required empty public constructor
    }

    public static OnBoardingWelcomeFragment newInstance(){
        return new OnBoardingWelcomeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_on_boarding_welcome, container, false);
        ob_welcome_iv = view.findViewById(R.id.ob_welcome_iv);
        return view;
    }

}
