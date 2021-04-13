
package com.example.firstip.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Team {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @Expose
    private String nickname;

    @SerializedName("shortName")
    @Expose
    private String shortName;
    /*
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("teamId")
    @Expose
    private String teamId;
    @SerializedName("nickname")
    @Expose
    private String nickname;

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

        */
    String index;
    public Team(){}

    public Team(String city,String logo,String fullName,String shortName,String nickname){
        this.city = city;
        this.logo =logo;
        this.fullName = fullName;
        this.shortName = shortName;
        this.nickname = nickname;
        this.index = "not sepcified";
    }
    public String getIndex(){
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCity() {
        return city;
    }
    public String getLogo() {
        return logo;
    }

    public String getFullName() {
        return fullName;
    }
    public String getNickname() {
        return nickname;
    }
    public String getShortName() {
        return shortName;
    }
/*


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

 */

}
