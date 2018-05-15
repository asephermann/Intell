package com.example.sweetseedsapp.models;


/**
 * Created by vivianbabiryekulumba on 5/14/18.
 */

public class HomeModel {

    int image;
    String text;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HomeModel(int image, String text) {

        this.image = image;
        this.text = text;
    }
}
