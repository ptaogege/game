package com.tao.vo;

/**
 * 视图类
 */
public class RankVo {
    private String username;
    private Integer score;
    private String date;


    public RankVo(String username, Integer score, String date) {
        this.username = username;
        this.score = score;
        this.date = date;
    }

    public RankVo() {
    }

    @Override
    public String toString() {
        return "RankVo{" +
                "username='" + username + '\'' +
                ", score=" + score +
                ", date='" + date + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
