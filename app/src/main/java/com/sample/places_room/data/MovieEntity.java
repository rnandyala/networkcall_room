package com.sample.places_room.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie_details")
public class MovieEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int mcompanyId;
    private String id;
    private String title;
    private String description;
    private String director;
    private String producer;
    private String release_date;
    private String rt_score;
    //  ArrayList<Object> people = new ArrayList<Object>();
    // ArrayList<Object> species = new ArrayList<Object>();
    // ArrayList<Object> locations = new ArrayList<Object>();
    //ArrayList<Object> vehicles = new ArrayList<Object>();
    private String url;
    private String length = null;


    // Getter Methods
    public int getMcompanyId() {
        return mcompanyId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getRt_score() {
        return rt_score;
    }

    public String getUrl() {
        return url;
    }

    public String getLength() {
        return length;
    }

    // Setter Methods

    public void setMcompanyId(int mcompanyId) {
        this.mcompanyId = mcompanyId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setRt_score(String rt_score) {
        this.rt_score = rt_score;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLength(String length) {
        this.length = length;
    }


    public MovieEntity(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
