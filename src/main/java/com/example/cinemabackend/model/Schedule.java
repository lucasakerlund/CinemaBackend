package com.example.cinemabackend.model;

public class Schedule {
    private int scheduleId;
    private String date;
    private String time;
    private int movieId;
    private int salon;

    public Schedule (int scheduleId, String date, String time, int movieId, int salon) {
        this.scheduleId = scheduleId;
        this.date = date;
        this.time = time;
        this.movieId = movieId;
        this.salon = salon;
    }

    public int getScheduleId() {return scheduleId;}

    public void setScheduleId(int scheduleId) {this.scheduleId = scheduleId;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}

    public int getMovieId() {return movieId;}

    public void setMovieId(int movieId) {this.movieId = movieId;}

    public int getSalon() {return salon;}

    public void setSalon(int salon) {this.salon = salon;}

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", movieId=" + movieId +
                ", salon=" + salon +
                '}';
    }
}
