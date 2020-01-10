package com.example.instagramreplica.models;

public class StoryModel {

    private String name;
    private String photos;


    public StoryModel(String name, String photos)
    {
        this.photos = photos;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
}
