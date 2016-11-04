package com.theironyard.entities;

import com.theironyard.jsonInputEntities.*;

/**
 * Created by Zach on 11/3/16.
 */
public class ViewResult {
    private String artwork_448x252;
    private String artwork_208x117;
    private String id;
    private String title;
    private String overview;
    private String first_aired;
    private Genres[] genres;
    private String runtime;
    private String type;
    private String themoviedb;
    private String network;
    private String fanart;
    private Social social;
    private String air_time;
    private String container_show;
    private String banner;
    private Tags[] tags;
    private String artwork_608x342;
    private String status;
    private Channels[] channels;
    private String wikipedia_id;
    private String url;
    private String[] alternate_titles;
    private String metacritic;
    private Cast[] cast;
    private String tv_com;
    private String imdb_id;
    private String tvdb;
    private String artwork_304x171;
    private String poster;
    private String freebase;
    private String rating;
    private String air_day_of_week;
    private Object live_stream;


    public ViewResult() {
    }

    public ViewResult(String artwork_448x252, String artwork_208x117, String id, String title, String overview) {
        this.artwork_448x252 = artwork_448x252;
        this.artwork_208x117 = artwork_208x117;
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public String getArtwork_208x117() {
        return artwork_208x117;
    }

    public void setArtwork_208x117(String artwork_208x117) {
        this.artwork_208x117 = artwork_208x117;
    }

    public String getArtwork_448x252() {
        return artwork_448x252;
    }

    public void setArtwork_448x252(String artwork_448x252) {
        this.artwork_448x252 = artwork_448x252;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}