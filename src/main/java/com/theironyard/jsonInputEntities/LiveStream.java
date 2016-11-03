package com.theironyard.jsonInputEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Zach on 11/3/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveStream {

    private String[] android;

    private String[] ios;

    private String[] web;

    public String[] getAndroid() {
        return android;
    }

    public void setAndroid(String[] android) {
        this.android = android;
    }

    public String[] getIos() {
        return ios;
    }

    public void setIos(String[] ios) {
        this.ios = ios;
    }

    public String[] getWeb() {
        return web;
    }

    public void setWeb(String[] web) {
        this.web = web;
    }

    @Override
    public String toString() {
        return "ClassPojo [android = " + android + ", ios = " + ios + ", web = " + web + "]";
    }
}
