package com.theironyard.jsonInputEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Zach on 11/3/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cast {
    private String id;

    private String character_name;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCharacter_name() {
        return character_name;
    }

    public void setCharacter_name(String character_name) {
        this.character_name = character_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", character_name = " + character_name + ", name = " + name + "]";
    }
}