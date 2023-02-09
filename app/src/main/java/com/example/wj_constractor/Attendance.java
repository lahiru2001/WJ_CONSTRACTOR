package com.example.wj_constractor;

public class Attendance {
    private String markId;
    private String markName;
    private String markDate;

    public Attendance(String markId, String markName, String markDate) {
        this.markId = markId;
        this.markName = markName;
        this.markDate = markDate;
    }
    public Attendance(String markId) {
        this.markId = "";
        this.markName = "";
        this.markDate = "";
    }

    public String getMarkId() {
        return markId;
    }

    public void setMarkId(String markId) {
        this.markId = markId;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public String getMarkDate() {
        return markDate;
    }

    public void setMarkDate(String markDate) {
        this.markDate = markDate;
    }
}
