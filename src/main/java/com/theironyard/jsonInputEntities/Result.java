package com.theironyard.jsonInputEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by Zach on 11/1/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {
    private String artwork_448x252;
    private String first_aired;
    private String artwork_608x342;
    private String wikipedia_id;
    private String themoviedb;
    private String[] alternate_titles;
    private String id;
    private String title;
    private String artwork_208x117;
    private String imdb_id;
    private String tvdb;
    private String artwork_304x171;
    private String freebase;
    private Tvrage tvrage;
    private String container_show;

    public String getArtwork_448x252() {
        return artwork_448x252;
    }

    public void setArtwork_448x252(String artwork_448x252) {
        this.artwork_448x252 = artwork_448x252;
    }

    public String getFirst_aired() {
        return first_aired;
    }

    public void setFirst_aired(String first_aired) {
        this.first_aired = first_aired;
    }

    public String getArtwork_608x342() {
        return artwork_608x342;
    }

    public void setArtwork_608x342(String artwork_608x342) {
        this.artwork_608x342 = artwork_608x342;
    }

    public String getWikipedia_id() {
        return wikipedia_id;
    }

    public void setWikipedia_id(String wikipedia_id) {
        this.wikipedia_id = wikipedia_id;
    }

    public String getThemoviedb() {
        return themoviedb;
    }

    public void setThemoviedb(String themoviedb) {
        this.themoviedb = themoviedb;
    }

    public String[] getAlternate_titles() {
        return alternate_titles;
    }

    public void setAlternate_titles(String[] alternate_titles) {
        this.alternate_titles = alternate_titles;
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

    public String getArtwork_208x117() {
        return artwork_208x117;
    }

    public void setArtwork_208x117(String artwork_208x117) {
        this.artwork_208x117 = artwork_208x117;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getTvdb() {
        return tvdb;
    }

    public void setTvdb(String tvdb) {
        this.tvdb = tvdb;
    }

    public String getArtwork_304x171() {
        return artwork_304x171;
    }

    public void setArtwork_304x171(String artwork_304x171) {
        this.artwork_304x171 = artwork_304x171;
    }

    public String getFreebase() {
        return freebase;
    }

    public void setFreebase(String freebase) {
        this.freebase = freebase;
    }

    public Tvrage getTvrage() {
        return tvrage;
    }

    public void setTvrage(Tvrage tvrage) {
        this.tvrage = tvrage;
    }

    public String getContainer_show() {
        return container_show;
    }

    public void setContainer_show(String container_show) {
        this.container_show = container_show;
    }
}
