package com.company.model;

import com.company.enums.State;

public class Truck {
    private int id;
    private String name;
    private State state;
    private Driver driver;

    public Truck(int id, String name, State state, Driver driver) {
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", driver=" + driver +
                '}';
    }
}
