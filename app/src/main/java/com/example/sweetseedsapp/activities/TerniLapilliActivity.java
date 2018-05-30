package com.example.sweetseedsapp.activities;

import android.annotation.TargetApi;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.controllersandviews.DragListener;
import com.example.sweetseedsapp.controllersandviews.LongPressListener;

public class TerniLapilliActivity extends AppCompatActivity {
    private static final String TAG = "LogicalActivity";

    private GridLayout gridLayout;
    private LinearLayout linearLayout;

    private static LinearLayout ll1;
    private static LinearLayout ll2;
    private static LinearLayout ll3;
    private static LinearLayout ll4;
    private static LinearLayout ll5;
    private static LinearLayout ll6;
    private static LinearLayout ll7;
    private static LinearLayout ll8;
    private static LinearLayout ll9;

    //View and type text for round text at the top.
    private static TextView round_text;
    Typeface typeface;

    //Used for determining if the game is over
    //private static int[][] possibleWinningCombo = {{R.id.topleft, R.id.topmiddle, R.id.topright}, {R.id.middleleft, R.id.middle, R.id.middleright}, {R.id.bottomleft, R.id.middlebottom, R.id.bottomright}, {R.id.topleft, R.id.middleleft, R.id.bottomleft}, {R.id.topmiddle, R.id.middle, R.id.middlebottom}, {R.id.topright, R.id.middleright, R.id.bottomright}, {R.id.topleft, R.id.middle, R.id.bottomright}, {R.id.bottomleft, R.id.middle, R.id.topright}};
    //private static int[] boardPieces = {R.id.topleft, R.id.topmiddle, R.id.topright,
    //R.id.middleleft, R.id.middle, R.id.middleright, R.id.bottomleft, R.id.middlebottom, R.id.bottomright};

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terni_lapilli);

        gridLayout = findViewById(R.id.grid_layout);
        linearLayout = findViewById(R.id.linear_layout);

        //To set the text type.
        typeface = Typeface.createFromAsset(getAssets(), "fonts/edo.ttf");

        ll1 = findViewById(R.id.topleft);
        ll2 = findViewById(R.id.topmiddle);
        ll3 = findViewById(R.id.topright);
        ll4 = findViewById(R.id.middleleft);
        ll5 = findViewById(R.id.middle);
        ll6 = findViewById(R.id.middleright);
        ll7 = findViewById(R.id.bottomleft);
        ll8 = findViewById(R.id.middlebottom);
        ll9 = findViewById(R.id.bottomright);

        TypedArray arrayResources = getResources().obtainTypedArray(
                R.array.resicon);

        ll1.setOnDragListener(new DragListener());
        ll2.setOnDragListener(new DragListener());
        ll3.setOnDragListener(new DragListener());
        ll4.setOnDragListener(new DragListener());
        ll5.setOnDragListener(new DragListener());
        ll6.setOnDragListener(new DragListener());
        ll7.setOnDragListener(new DragListener());
        ll8.setOnDragListener(new DragListener());
        ll9.setOnDragListener(new DragListener());

        round_text = findViewById(R.id.round_text);
        round_text.setTypeface(typeface);

        for (int i = 0; i < arrayResources.length(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageDrawable(arrayResources.getDrawable(i));
            imageView.setOnLongClickListener(new LongPressListener());
            linearLayout.addView(imageView);
        }

    }

    //Set up game logic
}
