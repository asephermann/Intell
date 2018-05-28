package com.example.sweetseedsapp.controllersandviews;

import android.content.ClipData;
import android.content.ClipDescription;
import android.view.View;

/**
 * Created by vivianbabiryekulumba on 5/27/18.
 */

public class LongPressListener implements View.OnLongClickListener {

    @Override
    public boolean onLongClick(View v) {
        // Create a new ClipData.Item from the View object's tag
        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());

        // Create a new ClipData using the tag as a label, the plain text MIME type, and
        // the already-created item. This will create a new ClipDescription object within the
        // ClipData, and set its MIME type entry to "text/plain"
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);

        // Instantiates the drag shadow builder.
        View.DragShadowBuilder dragshadow = new View.DragShadowBuilder(v);

        // Starts the drag
        v.startDrag(data       // data to be dragged
                , dragshadow  // drag shadow
                , v            // local data about the drag and drop operation
                , 0          // flags set to 0 because not using currently
        );
        return true;
    }
}
