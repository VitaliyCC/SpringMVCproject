package com.example.springmvcproject.model;

public class Questions {
    private int id;
    private String qestion;
    private String ansver;
    private int point;

    public Questions() {
    }

    public Questions(int id, String qestion, String ansver, int point) {
        this.id = id;
        this.qestion = qestion;
        this.ansver = ansver;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQestion() {
        return qestion;
    }

    public void setQestion(String qestion) {
        this.qestion = qestion;
    }

    public String getAnsver() {
        return ansver;
    }

    public void setAnsver(String ansver) {
        this.ansver = ansver;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
