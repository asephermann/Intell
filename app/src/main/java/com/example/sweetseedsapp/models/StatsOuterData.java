package com.example.sweetseedsapp.models;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 4/24/18.
 */

public class StatsOuterData {

    private int image;
    private int text;
    private List<StatsOuterData> statsOuterDataList;
    private List<StatsInnerRVData> statsInnerRVDataList;

    public List<StatsGridViewData> getGridViewData() {
        return gridViewData;
    }

    public void setGridViewData(List<StatsGridViewData> gridViewData) {
        this.gridViewData = gridViewData;
    }

    private List<StatsGridViewData> gridViewData;


    public StatsOuterData(int imageView) {
        this.image = imageView;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }

    public List<StatsOuterData> getStatsOuterDataList() {
        return statsOuterDataList;
    }

    public void setStatsOuterDataList(List<StatsOuterData> statsOuterDataList) {
        this.statsOuterDataList = statsOuterDataList;
    }

    public List<StatsInnerRVData> getStatsInnerRVDataList() {
        return statsInnerRVDataList;
    }

    public void setStatsInnerRVDataList(List<StatsInnerRVData> statsInnerRVDataList) {
        this.statsInnerRVDataList = statsInnerRVDataList;
    }
}
