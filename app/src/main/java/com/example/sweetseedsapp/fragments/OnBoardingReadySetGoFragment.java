package com.example.sweetseedsapp.fragments;


import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
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
    Typeface typeface;

    public OnBoardingReadySetGoFragment() {
        // Required empty public constructor
    }

    public static OnBoardingReadySetGoFragment newInstance() {
        return new OnBoardingReadySetGoFragment();
    }

    @Override
    @NonNull
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_on_boarding_ready_set_go, container, false);
        readySetGo1 = view.findViewById(R.id.ready);
        readySetGo2 = view.findViewById(R.id.set);
        readySetGo3 = view.findViewById(R.id.go);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                readySetGo1.setText(R.string.ready);
                typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/edo.ttf");
                readySetGo1.setTypeface(typeface);

            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                readySetGo2.setText(R.string.set);
                typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/edo.ttf");
                readySetGo2.setTypeface(typeface);

            }
        }, 2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                readySetGo3.setText(R.string.go);
                typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/edo.ttf");
                readySetGo3.setTypeface(typeface);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        }, 4000);
        return view;
    }

}
