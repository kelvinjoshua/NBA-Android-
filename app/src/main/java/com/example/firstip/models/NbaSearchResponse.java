
package com.example.firstip.models;

import java.util.List;
//import javax.annotation.Generated;

import com.example.firstip.models.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

//@Generated("jsonschema2pojo")
@Parcel
public class NbaSearchResponse {

    @SerializedName("teams")
    @Expose
    private List<Team> teams = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NbaSearchResponse() {
    }

    /**
     * 
     * @param teams
     */
    public NbaSearchResponse(List<Team> teams) {
        super();
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

}
