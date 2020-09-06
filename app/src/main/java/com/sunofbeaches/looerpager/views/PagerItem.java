package com.sunofbeaches.looerpager.views;

public class PagerItem {
    private String title;

    private String picResId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicResId() {
        return picResId;
    }

    public void setPicResId(String picResId) {
        this.picResId = picResId;
    }

    public PagerItem(String title,String picResId) {
        this.title = title;
        this.picResId = picResId;
    }
}
