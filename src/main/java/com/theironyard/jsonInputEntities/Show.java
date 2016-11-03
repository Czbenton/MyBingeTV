package com.theironyard.jsonInputEntities;

/**
 * Created by Zach on 11/2/16.
 */
public class Show {
    private Result[] results;
    private String total_results;

    @Override
    public String toString() {
        return "STRING OVERRIDE:--Show-- results = " + results + ", total_results = " + total_results + "";
    }


    public Result[] getResults() {
        return results;
    }
    public Result getResults(int index) {
        return results[index];
    }

    public void setResults(Result[] results) {
        this.results = results;
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }
}
