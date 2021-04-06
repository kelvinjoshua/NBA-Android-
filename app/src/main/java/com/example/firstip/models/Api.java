
package com.example.firstip.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Api {

    @SerializedName("status")
    @Expose
    private Integer status;
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

    /**
     * No args constructor for use in serialization
     * public Api() {
     *     }
     */


    /**
     * 
     * @param teams
     * @param filters
     * @param message
     * @param results
     * @param status
     */
    public Api(Integer status, String message, Integer results, List<String> filters, List<Team> teams) {
        super();
        this.status = status;
        this.message = message;
        this.results = results;
        this.filters = filters;
        this.teams = teams;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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
