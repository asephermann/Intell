package com.example.sweetseedsapp.models;

/**
 * Created by vivianbabiryekulumba on 4/24/18.
 */

public class StatsInnerRVModel {

    private int badge;
    private int position;

    public StatsInnerRVModel(int badge, int resId) {
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
}
