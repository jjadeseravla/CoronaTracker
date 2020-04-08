package io.javabrains.coronatracker.models;

public class LocationStats {

    private String state;
    private String country;
    private int latestTotalCases;

    public int getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '/' +
                ", country='" + country + '/' +
                ", latestTotalCases='" + latestTotalCases +
                '}';
    }
}