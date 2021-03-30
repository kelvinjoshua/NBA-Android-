
package com.example.firstip.models;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Team {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("teamId")
    @Expose
    private String teamId;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("allStar")
    @Expose
    private String allStar;
    @SerializedName("nbaFranchise")
    @Expose
    private String nbaFranchise;
    @SerializedName("leagues")
    @Expose
    private Leagues leagues;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Team() {
    }

    /**
     * 
     * @param allStar
     * @param city
     * @param leagues
     * @param teamId
     * @param nbaFranchise
     * @param nickname
     * @param fullName
     * @param logo
     * @param shortName
     */
    public Team(String city, String fullName, String teamId, String nickname, String logo, String shortName, String allStar, String nbaFranchise, Leagues leagues) {
        super();
        this.city = city;
        this.fullName = fullName;
        this.teamId = teamId;
        this.nickname = nickname;
        this.logo = logo;
        this.shortName = shortName;
        this.allStar = allStar;
        this.nbaFranchise = nbaFranchise;
        this.leagues = leagues;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAllStar() {
        return allStar;
    }

    public void setAllStar(String allStar) {
        this.allStar = allStar;
    }

    public String getNbaFranchise() {
        return nbaFranchise;
    }

    public void setNbaFranchise(String nbaFranchise) {
        this.nbaFranchise = nbaFranchise;
    }

    public Leagues getLeagues() {
        return leagues;
    }

    public void setLeagues(Leagues leagues) {
        this.leagues = leagues;
    }

}
