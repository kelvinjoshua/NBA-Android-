
package com.example.firstip.model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Team {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    /*
    @SerializedName("teamId")
    @Expose
    private Integer teamId;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("allStar")
    @Expose
    private Integer allStar;
    @SerializedName("nbaFranchise")
    @Expose
    private Integer nbaFranchise;
    @SerializedName("leagues")
    @Expose
    private Leagues leagues;
       */
    public Team(){}
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

    public String getLogo() {
        return logo;
    }

    public String getShortName() {
        return shortName;
    }

    public String getNickname() {
        return nickname;
    }
        /*
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
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

    public Integer getAllStar() {
        return allStar;
    }

    public void setAllStar(Integer allStar) {
        this.allStar = allStar;
    }

    public Integer getNbaFranchise() {
        return nbaFranchise;
    }

    public void setNbaFranchise(Integer nbaFranchise) {
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
