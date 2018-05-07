package com.example.sweetseedsapp.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sweetseedsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment{

    public static final String ARG_SECTION_NUMBER = "section_number";

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle args = getArguments();
        int position = 0;
        if (args != null) {
            position = args.getInt(ARG_SECTION_NUMBER, 0);
        }

        View view1 = inflater.inflate(R.layout.fragment_on_boarding_home,
                container, false);

        View view2 = inflater.inflate(R.layout.fragment_on_boarding_stats,
                container, false);

        View view3 = inflater.inflate(R.layout.fragment_on_boarding_game,
                container, false);

        View view4 = inflater.inflate(R.layout.readysetgo,
                container, false);

        switch (position) {
            case 0:
                return view1;
            case 1:
                return view2;
            case 2:
                return view3;
            case 3:
                try {
                    Thread.sleep(2000);
                    return view4;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
}
