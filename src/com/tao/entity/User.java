package com.tao.entity;

public class User {
    private String username;
    private int password;
    private double rank;

    public User(String username, int password, double rank) {
        this.username = username;
        this.password = password;
        this.rank = rank;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
}
