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

    TextView readySetGo;

    public OnBoardingReadySetGoFragment() {
        // Required empty public constructor
    }

    public static OnBoardingReadySetGoFragment newInstance(){
        return new OnBoardingReadySetGoFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_on_boarding_ready_set_go, container, false);
        readySetGo = view.findViewById(R.id.readySetGo);

        //Ready, set, go on a handler to run one at a time and give it game effect
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
               readySetGo.setText(R.string.ready);
            }
        }, 1000);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                readySetGo.setText(R.string.set);
            }
        }, 1000);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                readySetGo.setText(R.string.go);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        }, 1000);

        return view;
    }

}
