package com.example.sweetseedsapp.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.fragments.OnBoardingGameFragment;
import com.example.sweetseedsapp.fragments.OnBoardingHomeFragment;
import com.example.sweetseedsapp.fragments.OnBoardingStatsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {


    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
    }
}
