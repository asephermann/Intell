package com.example.sweetseedsapp.models;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 4/24/18.
 */

public class StatsInnerRVData {

    private String color;
    private int resId;

    public List<String> getColorList() {
        return colorList;
    }

    public void setColorList(List<String> colorList) {
        this.colorList = colorList;
    }

    private List<String> colorList;


    public StatsInnerRVData(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
