package com.example.sweetseedsapp.controllersandviews;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.view.View;

/**
 * Created by vivianbabiryekulumba on 5/27/18.
 */

public class LongPressListener implements View.OnLongClickListener {

    @Override
    public boolean onLongClick(View v) {
        ClipData data = ClipData.newPlainText("", "");
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
        v.startDrag(data, shadowBuilder, v, 0);
        v.setVisibility(View.VISIBLE);
        return true;
    }
}
