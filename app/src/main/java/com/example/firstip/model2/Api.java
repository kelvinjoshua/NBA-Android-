
package com.example.firstip.model2;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Api {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("results")
    @Expose
    private Integer results;
    @SerializedName("filters")
    @Expose
    private List<String> filters = null;
    @SerializedName("teams")
    @Expose
    private List<Team> teams = null;
    public Api(){}
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

}
