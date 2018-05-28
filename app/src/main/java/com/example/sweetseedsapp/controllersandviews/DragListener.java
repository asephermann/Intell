package com.example.sweetseedsapp.controllersandviews;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.sweetseedsapp.R;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by vivianbabiryekulumba on 5/27/18.
 */

public class DragListener implements View.OnDragListener {

    private GridLayout mGrid;
    private ScrollView mScrollView;
    private ValueAnimator mAnimator;
    private AtomicBoolean mIsScrolling = new AtomicBoolean(false);

    @Override
    public boolean onDrag(View v, DragEvent event) {
        // Defines a variable to store the action type for the incoming event
        int action = event.getAction();
        // Handles each of the expected events
        switch (action) {


            case DragEvent.ACTION_DRAG_STARTED:


                // Determines if this View can accept the dragged data
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    // applies a blue color tint to the View to indicate that it can accept the data
                    v.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                    // Invalidate the view to force a redraw in the new tint
                    v.invalidate();
                    // returns true to indicate that the View can accept the dragged data.
                    return true;
                }
                // Returns false. During the current drag and drop operation, this View will
                // not receive events again until ACTION_DRAG_ENDED is sent.
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:


                // Applies a YELLOW or any color tint to the View. Return true; the return value is ignored.
                v.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
                // Invalidate the view to force a redraw in the new tint
                v.invalidate();
                return true;


            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the event
                return true;


            case DragEvent.ACTION_DRAG_EXITED:


                // Re-sets the color tint to blue, if you had set the BLUE color or any color in ACTION_DRAG_STARTED. Returns true; the return value is ignored.
                v.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                //If u had not provided any color in ACTION_DRAG_STARTED then clear color filter.
                v.getBackground().clearColorFilter();
                // Invalidate the view to force a redraw in the new tint
                v.invalidate();
                return true;
            case DragEvent.ACTION_DROP:
                // Gets the item containing the dragged data
                ClipData.Item item = event.getClipData().getItemAt(0);
                // Gets the text data from the item.
                String dragData = item.getText().toString();
                // Displays a message containing the dragged data.
//                Toast.makeText(this, .getString(R.string.drag) + dragData, Toast.LENGTH_SHORT).show();
                // Turns off any color tints
                v.getBackground().clearColorFilter();
                // Invalidates the view to force a redraw
                v.invalidate();
                // Returns true. DragEvent.getResult() will return true.
                return true;
            case DragEvent.ACTION_DRAG_ENDED:
                // Turns off any color tinting
                v.getBackground().clearColorFilter();
                // Invalidates the view to force a redraw
                v.invalidate();
                // Does a getResult(), and displays what happened.
                if (event.getResult()) {
//                    Toast.makeText(this, "The drop was handled.", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_SHORT).show();
                    // returns true; the value is ignored.
                    return true;
                }
                    // An unknown action type was received.
                    default:
                        Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                        break;
                }
                return false;
    }

}
