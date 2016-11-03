package com.theironyard.entities;

/**
 * Created by Zach on 11/3/16.
 */
public class ViewResult {
    private String artwork_448x252;
    private String artwork_208x117;
    private String id;
    private String title;
    private String overview;


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