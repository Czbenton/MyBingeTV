package com.theironyard.jsonInputEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Zach on 11/3/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowDetail {
    private String artwork_448x252;
    private String first_aired;
    private Genres[] genres;
    private String runtime;
    private String type;
    private String themoviedb;
    private String network;
    private String fanart;
    private String id;
    private String title;
    private String artwork_208x117;
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
    private String overview;
    private String tv_com;
    private String imdb_id;
    private String tvdb;
    private String artwork_304x171;
    private String poster;
    private String freebase;
    private String rating;
    private String air_day_of_week;
    private Object live_stream;

    public Object getLive_stream() {
        return live_stream;
    }

    public void setLive_stream(Object live_stream) {
        this.live_stream = live_stream;
    }

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

    public Genres[] getGenres() {
        return genres;
    }

    public void setGenres(Genres[] genres) {
        this.genres = genres;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getThemoviedb() {
        return themoviedb;
    }

    public void setThemoviedb(String themoviedb) {
        this.themoviedb = themoviedb;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getFanart() {
        return fanart;
    }

    public void setFanart(String fanart) {
        this.fanart = fanart;
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

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public String getAir_time() {
        return air_time;
    }

    public void setAir_time(String air_time) {
        this.air_time = air_time;
    }

    public String getContainer_show() {
        return container_show;
    }

    public void setContainer_show(String container_show) {
        this.container_show = container_show;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Tags[] getTags() {
        return tags;
    }

    public void setTags(Tags[] tags) {
        this.tags = tags;
    }

    public String getArtwork_608x342() {
        return artwork_608x342;
    }

    public void setArtwork_608x342(String artwork_608x342) {
        this.artwork_608x342 = artwork_608x342;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Channels[] getChannels() {
        return channels;
    }

    public void setChannels(Channels[] channels) {
        this.channels = channels;
    }

    public String getWikipedia_id() {
        return wikipedia_id;
    }

    public void setWikipedia_id(String wikipedia_id) {
        this.wikipedia_id = wikipedia_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String[] getAlternate_titles() {
        return alternate_titles;
    }

    public void setAlternate_titles(String[] alternate_titles) {
        this.alternate_titles = alternate_titles;
    }

    public String getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(String metacritic) {
        this.metacritic = metacritic;
    }

    public Cast[] getCast() {
        return cast;
    }

    public void setCast(Cast[] cast) {
        this.cast = cast;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTv_com() {
        return tv_com;
    }

    public void setTv_com(String tv_com) {
        this.tv_com = tv_com;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getFreebase() {
        return freebase;
    }

    public void setFreebase(String freebase) {
        this.freebase = freebase;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAir_day_of_week() {
        return air_day_of_week;
    }

    public void setAir_day_of_week(String air_day_of_week) {
        this.air_day_of_week = air_day_of_week;
    }
}
