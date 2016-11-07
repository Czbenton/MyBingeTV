package com.theironyard.entities;

import com.theironyard.jsonInputEntities.Channels;
import com.theironyard.jsonInputEntities.Genres;
import com.theironyard.jsonInputEntities.Social;
import com.theironyard.jsonInputEntities.Tags;

/**
 * Created by Zach on 11/3/16.
 */
public class ViewResult {
    private String artwork_448x252;
    private String artwork_208x117;
    private String id;
    private String title;
    private String overview;
    private String network;
    private Social social;
    private Tags[] tags;
    private Channels[] channels;
    private String rating;
    private Genres[] genres;
    private String tagString;
    private String url;


    public ViewResult() {
    }

    public ViewResult(String artwork_448x252, String artwork_208x117, String id, String title, String overview) {
        this.artwork_448x252 = artwork_448x252;
        this.artwork_208x117 = artwork_208x117;
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public ViewResult(String artwork_448x252, String artwork_208x117, String id, String title,
                      String overview, String network, Social social, Tags[] tags, Channels[] channels,
                      String rating, Genres[] genres) {
        this.artwork_448x252 = artwork_448x252;
        this.artwork_208x117 = artwork_208x117;
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.network = network;
        this.social = social;
        this.tags = tags;
        this.channels = channels;
        this.rating = rating;
        this.genres = genres;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTagString() {
        return tagString;
    }

    public void setTagString(String tagString) {
        this.tagString = tagString;
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

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public Tags[] getTags() {
        return tags;
    }

    public void setTags(Tags[] tags) {
        this.tags = tags;
    }

    public Channels[] getChannels() {
        return channels;
    }

    public void setChannels(Channels[] channels) {
        this.channels = channels;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Genres[] getGenres() {
        return genres;
    }

    public void setGenres(Genres[] genres) {
        this.genres = genres;
    }
}