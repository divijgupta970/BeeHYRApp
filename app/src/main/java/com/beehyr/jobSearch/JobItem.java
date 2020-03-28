package com.beehyr.jobSearch;

public class JobItem {
    private int jobIcon;
    private String jobType;
    private String salary;
    private String location;

    public JobItem(int jobIcon, String jobType, String salary, String location) {
        this.jobIcon = jobIcon;
        this.jobType = jobType;
        this.salary = salary;
        this.location = location;
    }

    public int getJobIcon() {
        return jobIcon;
    }

    public void setJobIcon(int jobIcon) {
        this.jobIcon = jobIcon;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
