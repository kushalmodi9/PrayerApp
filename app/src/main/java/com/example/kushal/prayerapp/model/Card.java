package com.example.kushal.prayerapp.model;

/**
 * Created by Kushal on 02-07-2015.
 */
public class Card {
    private String imageURL;
    private String title;
    private String textVideo;
    private String textLyrics;

    public Card() {

    }

    public Card(String imageURL, String title, String textVideo, String textLyrics) {
        this.imageURL = imageURL;
        this.title = title;
        this.textVideo = textVideo;
        this.textLyrics = textLyrics;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getTextVideo() {
        return textVideo;
    }

    public String getTextLyrics() {
        return textLyrics;
    }

}