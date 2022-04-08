package com.example.cinemabackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StaffSchedule {
    private int staffId;
    private String time;
    private String task;

    public StaffSchedule(@JsonProperty("staff_id") int staffId,
                         @JsonProperty("time") String time,
                         @JsonProperty("task") String task) {
        this.staffId = staffId;
        this.time = time;
        this.task = task;
    }

    public int getStaffId() {return staffId;}

    public void setStaffId(int StaffId) {this.staffId = staffId;}

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}

    public String getTask() {return task;}

    public void setTask(String Task) {this.task = task;}

    @Override
    public String toString() {
        return "StaffSchedule{" +
                "StaffId=" + staffId +
                ", Time='" + time + '\'' +
                ", Task='" + task + '\'' +
                '}';
    }

    public void insertStaffSchedule(String time, String task) {
    }
}
