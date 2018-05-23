package com.example.sweetseedsapp.activities;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sweetseedsapp.R;

public class LogicalActivity extends AppCompatActivity {

    ImageView stone1;
    ImageView stone2;
    ImageView stone3;
    ImageView stone4;
    ImageView stone5;
    ImageView stone6;
    ImageView stone7;
    ImageView stone8;
    ImageView stone9;
    ImageView stone10;
    TextView round_text;
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logical);

        stone1 = findViewById(R.id.stone1);
        stone2 = findViewById(R.id.stone2);
        stone3 = findViewById(R.id.stone3);
        stone4 = findViewById(R.id.stone4);
        stone5 = findViewById(R.id.stone5);
        stone6 = findViewById(R.id.stone6);
        stone7 = findViewById(R.id.stone7);
        stone8 = findViewById(R.id.stone8);
        stone9 = findViewById(R.id.stone9);
        stone10 = findViewById(R.id.stone10);

        round_text = findViewById(R.id.round_text);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/edo.ttf");
        round_text.setTypeface(typeface);

        //OnTouchListeners for the stones
        stone1.setOnTouchListener(new MyOnTouchListener());
        stone2.setOnTouchListener(new MyOnTouchListener());
        stone3.setOnTouchListener(new MyOnTouchListener());
        stone4.setOnTouchListener(new MyOnTouchListener());
        stone5.setOnTouchListener(new MyOnTouchListener());
        stone6.setOnTouchListener(new MyOnTouchListener());
        stone7.setOnTouchListener(new MyOnTouchListener());
        stone8.setOnTouchListener(new MyOnTouchListener());
        stone9.setOnTouchListener(new MyOnTouchListener());
        stone10.setOnTouchListener(new MyOnTouchListener());

        //OnDragListeners for the stones
        stone1.setOnDragListener(new MyDragListener());
        stone2.setOnDragListener(new MyDragListener());
        stone3.setOnDragListener(new MyDragListener());
        stone4.setOnDragListener(new MyDragListener());
        stone5.setOnDragListener(new MyDragListener());
        stone6.setOnDragListener(new MyDragListener());
        stone7.setOnDragListener(new MyDragListener());
        stone8.setOnDragListener(new MyDragListener());
        stone9.setOnDragListener(new MyDragListener());
        stone10.setOnDragListener(new MyDragListener());
    }

    private class MyOnTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(
                R.drawable.x);
//        Drawable normalShape = getResources().getDrawable(R.drawable.shape);

        @TargetApi(Build.VERSION_CODES.M)
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (action) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundDrawable(enterShape);
                    break;
//                case DragEvent.ACTION_DRAG_EXITED:
//                    v.setBackgroundDrawable(normalShape);
//                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.onViewAdded(view);
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE);
                    break;
//                case DragEvent.ACTION_DRAG_ENDED:
//                    v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
    }
}
