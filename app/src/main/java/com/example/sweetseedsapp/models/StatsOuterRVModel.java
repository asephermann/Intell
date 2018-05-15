package com.example.sweetseedsapp.models;

import java.util.List;

/**
 * Created by vivianbabiryekulumba on 4/24/18.
 */

public class StatsOuterRVModel {

    private int image;
    private int text;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private List<StatsOuterRVModel> statsOuterDataList;
    private List<StatsInnerRVModel> statsInnerRVDataList;

    public List<StatsGridViewModel> getGridViewData() {
        return gridViewData;
    }

    public void setGridViewData(List<StatsGridViewModel> gridViewData) {
        this.gridViewData = gridViewData;
    }

    private List<StatsGridViewModel> gridViewData;


    public StatsOuterRVModel(int imageView) {
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

    public List<StatsOuterRVModel> getStatsOuterDataList() {
        return statsOuterDataList;
    }

    public void setStatsOuterDataList(List<StatsOuterRVModel> statsOuterDataList) {
        this.statsOuterDataList = statsOuterDataList;
    }

    public List<StatsInnerRVModel> getStatsInnerRVDataList() {
        return statsInnerRVDataList;
    }

    public void setStatsInnerRVDataList(List<StatsInnerRVModel> statsInnerRVDataList) {
        this.statsInnerRVDataList = statsInnerRVDataList;
    }
}
