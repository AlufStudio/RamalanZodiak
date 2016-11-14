package com.madrish.ramalanzodiak.Adapter;

/**
 * Created by A MADRISH on 10/15/2016
 */

public class CardSquare {
    private String name;
    private int thumbnail;

    public CardSquare() {
    }

    public CardSquare(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
