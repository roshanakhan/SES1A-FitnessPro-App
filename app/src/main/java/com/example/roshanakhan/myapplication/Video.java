package com.example.roshanakhan.myapplication;

public class Video {
    String url ;
    String title;
    String des;

    public Video(String url, String title, String des) {
        this.url = url;
        this.title = title;
        this.des = des;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}

