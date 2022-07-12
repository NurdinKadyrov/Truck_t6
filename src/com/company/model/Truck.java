package com.company.model;

import com.company.enums.State;

public class Truck {
    private int id;
    private String name;
    private State state;
    private String driver;

    public Truck(int id, String name, State state, String driver) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.driver = driver;
    }

    public Truck() {

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "id: " + id +
                " Truck: " + name +
                " driver: " + driver;
    }
}
