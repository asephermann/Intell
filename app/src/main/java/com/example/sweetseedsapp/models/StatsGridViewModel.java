package com.example.sweetseedsapp.models;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 5/13/18.
 */

public class StatsGridViewModel {

    private int badge;
    private int position;

    public StatsGridViewModel(int badge, int resId) {
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

    List<StatsGridViewModel> gridViewData;

    public List<StatsGridViewModel> getGridViewData() {
        return gridViewData;
    }

    public void setGridViewData(List<StatsGridViewModel> gridViewData) {
        this.gridViewData = gridViewData;
    }
}
