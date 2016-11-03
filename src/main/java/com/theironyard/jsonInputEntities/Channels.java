package com.theironyard.jsonInputEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Zach on 11/3/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channels {
    private String id;

    private String artwork_448x252;

    private String artwork_608x342;

    private String artwork_208x117;

    private Social social;

    private String name;

    private String artwork_304x171;

    private String is_primary;

    private Object live_stream;

    private String short_name;

    private String channel_type;

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", artwork_448x252 = " + artwork_448x252 + ", artwork_608x342 = " + artwork_608x342 + ", artwork_208x117 = " + artwork_208x117 + ", social = " + social + ", name = " + name + ", artwork_304x171 = " + artwork_304x171 + ", is_primary = " + is_primary + ", live_stream = " + live_stream + ", short_name = " + short_name + ", channel_type = " + channel_type + "]";
    }

    public Object getLive_stream() {
        return live_stream;
    }

    public void setLive_stream(Object live_stream) {
        this.live_stream = live_stream;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtwork_448x252() {
        return artwork_448x252;
    }

    public void setArtwork_448x252(String artwork_448x252) {
        this.artwork_448x252 = artwork_448x252;
    }

    public String getArtwork_608x342() {
        return artwork_608x342;
    }

    public void setArtwork_608x342(String artwork_608x342) {
        this.artwork_608x342 = artwork_608x342;
    }

    public String getArtwork_208x117() {
        return artwork_208x117;
    }

    public void setArtwork_208x117(String artwork_208x117) {
        this.artwork_208x117 = artwork_208x117;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtwork_304x171() {
        return artwork_304x171;
    }

    public void setArtwork_304x171(String artwork_304x171) {
        this.artwork_304x171 = artwork_304x171;
    }

    public String getIs_primary() {
        return is_primary;
    }

    public void setIs_primary(String is_primary) {
        this.is_primary = is_primary;
    }


    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getChannel_type() {
        return channel_type;
    }

    public void setChannel_type(String channel_type) {
        this.channel_type = channel_type;
    }
}