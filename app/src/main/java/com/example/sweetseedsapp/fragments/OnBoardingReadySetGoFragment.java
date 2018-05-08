package com.example.sweetseedsapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnBoardingReadySetGoFragment extends Fragment {

    TextView readySetGo1;
    TextView readySetGo2;
    TextView readySetGo3;

    public OnBoardingReadySetGoFragment() {
        // Required empty public constructor
    }

    public static OnBoardingReadySetGoFragment newInstance() {
        return new OnBoardingReadySetGoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_on_boarding_ready_set_go, container, false);
        readySetGo1 = view.findViewById(R.id.ready);
        readySetGo2 = view.findViewById(R.id.set);
        readySetGo3 = view.findViewById(R.id.go);

        //Ready, set, go on a handler to run one at a time and give it game effect
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                readySetGo1.setText(R.string.ready);
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                readySetGo2.setText(R.string.set);
            }
        }, 3000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                readySetGo3.setText(R.string.go);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        }, 5000);
        return view;
    }

}
