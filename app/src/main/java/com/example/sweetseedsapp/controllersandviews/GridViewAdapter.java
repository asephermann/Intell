package com.example.sweetseedsapp.controllersandviews;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.sweetseedsapp.R;

/**
 * Created by vivianbabiryekulumba on 5/30/18.
 */

public class GridViewAdapter extends BaseAdapter {

    private Context mContext;

    public GridViewAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return badgeList.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(4, 4, 4, 4);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(badgeList[position]);
        return imageView;
    }

    // references to our images
    private Integer[] badgeList = {
            R.drawable.badge_one, R.drawable.badge_two,
            R.drawable.badge_three, R.drawable.badge_four,
            R.drawable.badge_five, R.drawable.badge_six,
            R.drawable.badge_seven, R.drawable.badge_eight,
            R.drawable.badge_nine, R.drawable.badge_nine,
            R.drawable.badge_ten, R.drawable.badge_eleven,
            R.drawable.badge_twelve, R.drawable.badge_thirteen, R.drawable.badge_fourteen};

    //For old recycler view
////    private static final String TAG = "GridViewAdapter.class";
////    private List<StatsGridViewModel> gridViewData ;
////
////    public GridViewAdapter(List<StatsGridViewModel> gridViewDataList) {
////        this.gridViewData = gridViewDataList;
////    }
////
////
////    @NonNull
////    @Override
////    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridview_item_view, parent, false);
////        return new GridViewHolder(view);
////    }
////
////    @Override
////    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
////        holder.onBind(gridViewData.get(position));
////    }
////
////    @Override
////    public int getItemCount() {
////        Log.d(TAG, "getItemCount: " + gridViewData.size());
////        return gridViewData.size();
////    }
////
////    class GridViewHolder extends RecyclerView.ViewHolder {
////
////        GridViewHolder(View itemView) {
////            super(itemView);
////        }
////
////        void onBind(StatsGridViewModel statsGridViewData) {
////            ImageView badge = itemView.findViewById(R.id.grid_view_iv);
////            badge.setImageResource(statsGridViewData.getBadge());
////        }
//
//    }

}
