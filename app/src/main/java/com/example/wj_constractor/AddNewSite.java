package com.example.wj_constractor;

public class AddNewSite {

    private String id;
    private String siteName;
    private String SuperId;
    private String location;
    private String startDate;

    public AddNewSite(String id, String siteName, String superId, String location, String startDate) {
        this.id = id;
        this.siteName = siteName;
        SuperId = superId;
        this.location = location;
        this.startDate = startDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSuperId() {
        return SuperId;
    }

    public void setSuperId(String superId) {
        SuperId = superId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

}
