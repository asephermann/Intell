package com.example.sweetseedsapp.models;

import android.graphics.drawable.Drawable;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 5/13/18.
 */

public class StatsGridViewData {

    private int badge;
    private int position;

    public StatsGridViewData(int badge, int resId) {
        this.badge = badge;
        this.position = resId;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    List<StatsGridViewData> gridViewData;

    public List<StatsGridViewData> getGridViewData() {
        return gridViewData;
    }

    public void setGridViewData(List<StatsGridViewData> gridViewData) {
        this.gridViewData = gridViewData;
    }
}
