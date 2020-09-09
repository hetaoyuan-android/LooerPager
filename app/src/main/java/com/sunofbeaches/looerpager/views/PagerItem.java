package com.sunofbeaches.looerpager.views;

public class PagerItem {
    private String title;

    private int picResId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPicResId() {
        return picResId;
    }

    public void setPicResId(int picResId) {
        this.picResId = picResId;
    }

    public PagerItem(String title,int picResId) {
        this.title = title;
        this.picResId = picResId;
    }
}
