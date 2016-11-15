package com.theironyard.jsonInputEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Zach on 11/1/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tvrage {
    private String link;
    private String tvrage_id;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTvrage_id() {
        return tvrage_id;
    }

    public void setTvrage_id(String tvrage_id) {
        this.tvrage_id = tvrage_id;
    }

}
