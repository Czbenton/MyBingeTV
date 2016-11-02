package com.theironyard.entities;

/**
 * Created by Zach on 11/2/16.
 */
public class Show {
    private Results[] results;
    private String total_results;

//    @Override
//    public String toString() {
//        return "STRING OVERRIDE:--Show-- results = " + results + ", total_results = " + total_results + "";
//    }

    @Override
    public String toString() {
        return results[0].getId();
    }

    public Results[] getResults() {
        return results;
    }
    public Results getResults(int index) {
        return results[index];
    }

    public void setResults(Results[] results) {
        this.results = results;
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }
}
