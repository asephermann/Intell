package com.example.sweetseedsapp.controllersandviews;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.DragEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.GridLayout;
import android.widget.ScrollView;

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
        final View view = (View) event.getLocalState();
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_LOCATION:
                // do nothing if hovering above own position
                if (view == v) return true;
                // get the new list index
                final int index = calculateNewIndex(event.getX(), event.getY());

                final int scrollY = mScrollView.getScrollY();
                final Rect rect = new Rect();
                mScrollView.getHitRect(rect);

                if (event.getY() -  scrollY > mScrollView.getBottom() - 250) {
                    startScrolling(scrollY, mGrid.getHeight());
                } else if (event.getY() - scrollY < mScrollView.getTop() + 250) {
                    startScrolling(scrollY, 0);
                } else {
                    stopScrolling();
                }

                // remove the view from the old position
                mGrid.removeView(view);
                // and push to the new
                mGrid.addView(view, index);
                break;
            case DragEvent.ACTION_DROP:
                view.setVisibility(View.VISIBLE);
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                if (!event.getResult()) {
                    view.setVisibility(View.VISIBLE);
                }
                break;
        }
        return true;
    }

    private int calculateNewIndex(float x, float y) {
        // calculate which column to move to
        final float cellWidth = mGrid.getWidth() / mGrid.getColumnCount();
        final int column = (int)(x / cellWidth);

        // calculate which row to move to
        final float cellHeight = mGrid.getHeight() / mGrid.getRowCount();
        final int row = (int)Math.floor(y / cellHeight);

        // the items in the GridLayout is organized as a wrapping list
        // and not as an actual grid, so this is how to get the new index
        int index = row * mGrid.getColumnCount() + column;
        if (index >= mGrid.getChildCount()) {
            index = mGrid.getChildCount() - 1;
        }

        return index;
    }


    private void startScrolling(int from, int to) {
        if (from != to && mAnimator == null) {
            mIsScrolling.set(true);
            mAnimator = new ValueAnimator();
            mAnimator.setInterpolator(new OvershootInterpolator());
            mAnimator.setDuration(Math.abs(to - from));
            mAnimator.setIntValues(from, to);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    mScrollView.smoothScrollTo(0, (int) valueAnimator.getAnimatedValue());
                }
            });
            mAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mIsScrolling.set(false);
                    mAnimator = null;
                }
            });
            mAnimator.start();
        }
    }

    private void stopScrolling() {
        if (mAnimator != null) {
            mAnimator.cancel();
        }
    }


}
