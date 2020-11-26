package com.tao.po;

public class Rank {
    private Integer id;
    private Integer score;
    private String date;
    private Integer userId;

    public Rank(Integer id, Integer score, String date, Integer userId) {
        this.id = id;
        this.score = score;
        this.date = date;
        this.userId = userId;
    }

    public Rank() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
