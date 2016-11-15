package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by jeremypitt on 11/2/16.
 */
@Entity
@Table(name = "saved_shows")
public class SavedShow {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String title;

    @Column
    private String artwork;

    @Column
    private String showid;

    @Column
    private String overview;

    @Column
    private String rating;

    @Column
    private String runtime;

    @ManyToOne
    private User user;

    public SavedShow() {
    }

    public SavedShow(String title, String artwork, String showid, String overview, String rating, String runtime, User user) {
        this.title = title;
        this.artwork = artwork;
        this.showid = showid;
        this.overview = overview;
        this.rating = rating;
        this.runtime = runtime;
        this.user = user;
    }

    public String getRuntime() {

        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    public String getShowid() {
        return showid;
    }

    public void setShowid(String showid) {
        this.showid = showid;
    }

    public String getRating() {

        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
