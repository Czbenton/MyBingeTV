package com.theironyard.jsonInputEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Zach on 11/3/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tags {
    private String id;
    private String tag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return tag + " ";
    }
}