package com.t3h.buoi10.model;

public class CaterogyNews {
    int imageResource;
    String title;
    String url;

    public CaterogyNews(int imageResource, String title, String url) {
        this.imageResource = imageResource;
        this.title = title;
        this.url = url;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
