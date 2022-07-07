package com.company.model;

import com.company.enums.Situation;


public class Driver {
    private int id;
    private String name;
    private Situation situation;
    private String driveName;

    public Driver(int id, String name, Situation situation, String driveName) {
        this.id = id;
        this.name = name;
        this.situation = situation;
        this.driveName = driveName;
    }

    public Driver() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public String getDriveName() {
        return driveName;
    }

    public void setDriveName(String driveName) {
        this.driveName = driveName;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", situation=" + situation +
                ", driveName='" + driveName;
    }

    }

