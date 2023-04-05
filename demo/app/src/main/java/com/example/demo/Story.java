package com.example.demo;

public class Story {

    private String title;
    private String content;
    private int imageResource;

    public Story(String title, String content, int imageResource) {
        this.title = title;
        this.content = content;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getImageResource() {
        return imageResource;
    }
}
