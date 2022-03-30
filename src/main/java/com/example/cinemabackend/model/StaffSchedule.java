package com.example.cinemabackend.model;

public class StaffSchedule {
    private int StaffId;
    private String Time;
    private String Task;

    public StaffSchedule(int StaffId, String Time, String Task) {
        this.StaffId = StaffId;
        this.Time = Time;
        this.Task = Task;
    }

    public int getStaffId() {return StaffId;}

    public void setStaffId(int StaffId) {this.StaffId = StaffId;}

    public String getTime() {return Time;}

    public void setTime(String Time) {this.Time = Time;}

    public String getTask() {return Task;}

    public void setTask(String Task) {this.Task = Task;}

    @Override
    public String toString() {
        return "StaffSchedule{" +
                "StaffId=" + StaffId +
                ", Time='" + Time + '\'' +
                ", Task='" + Task + '\'' +
                '}';
    }
}
