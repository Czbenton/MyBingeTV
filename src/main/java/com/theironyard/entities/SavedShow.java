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
    int id;

    @Column
    String title;

    @Column
    String artwork;

    @Column
    String showid;

    @ManyToOne
    User user;

    public SavedShow() {
    }

    public SavedShow(String title, String artwork, String showid) {

        this.title = title;
        this.artwork = artwork;
        this.showid = showid;
    }

    public SavedShow(String title, String artwork, String showid, User user) {
        this.title = title;
        this.artwork = artwork;
        this.showid = showid;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
