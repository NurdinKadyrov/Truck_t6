package com.company.dao;

import com.company.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverDao {
     private final List<Driver> driverList = new ArrayList<>();

    public List<Driver> getDriverList() {
        return driverList;
    }
}


